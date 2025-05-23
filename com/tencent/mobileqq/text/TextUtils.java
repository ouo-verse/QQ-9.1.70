package com.tencent.mobileqq.text;

import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.Layout;
import android.util.SparseArray;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSmallEmoUtils;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqemoticon.api.IEmoticonManager;
import com.tencent.mobileqq.util.cn;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import kotlin.text.Typography;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class TextUtils {
    static IPatchRedirector $redirector_ = null;
    public static final int COLOR_NICK_EMOTICON_HEAD = 36;
    public static final int COLOR_NICK_GRADIENT_COLOR_HEAD = 37;
    public static final int COLOR_NICK_PURE_COLOR_HEAD = 38;
    public static final int EMO_PREFIX = 20;
    public static final int FACE_REPLACE_NUM;
    public static final int SPACE_POINT_CODE = 32;
    private static final String TAG = "TextUtils";

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface LoadSysEmojiCallback {
        void callbackWhenSysEmojiLoaded(Drawable drawable);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42686);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            FACE_REPLACE_NUM = EmotcationConstants.EMOJI_CONTENT_DESC.length;
        }
    }

    public TextUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String Symbol2FavoriteSymbol(String str) {
        int length;
        int i3;
        int i16;
        String str2;
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        if (!hasSysEmotion(str)) {
            return str;
        }
        IEmoticonManager emoMgr = getEmoMgr();
        StringBuilder sb5 = new StringBuilder(str);
        int i17 = 0;
        while (i17 < sb5.length()) {
            if (sb5.codePointAt(i17) == 20 && i17 < sb5.length() - 1) {
                int i18 = i17 + 1;
                char charAt = sb5.charAt(i18);
                if (!QQSysFaceUtil.isValidFaceId(charAt) && '\u00fa' != charAt) {
                    if (charAt == '\u00ff') {
                        int i19 = i17 + 4;
                        if (i19 >= sb5.length()) {
                            String str3 = AbsQQText.SMALL_EMOJI_SYMBOL;
                            sb5.replace(i17, sb5.length(), str3);
                            i17 += str3.length() - 1;
                        } else {
                            char[] cArr = new char[4];
                            cArr[0] = sb5.charAt(i19);
                            cArr[1] = sb5.charAt(i17 + 3);
                            cArr[2] = sb5.charAt(i17 + 2);
                            cArr[3] = sb5.charAt(i18);
                            for (int i26 = 0; i26 < 3; i26++) {
                                char c16 = cArr[i26];
                                if (c16 == '\u00fa') {
                                    cArr[i26] = '\n';
                                } else if (c16 == '\u00fe') {
                                    cArr[i26] = '\r';
                                }
                            }
                            int[] emoDescripFromChars = QQSmallEmoUtils.getEmoDescripFromChars(cArr);
                            if (emoDescripFromChars != null && emoDescripFromChars.length == 2) {
                                i16 = emoDescripFromChars[0];
                                i3 = emoDescripFromChars[1];
                            } else {
                                i3 = 0;
                                i16 = 0;
                            }
                            if (emoMgr == null) {
                                str2 = "";
                            } else {
                                str2 = emoMgr.syncGetEmoticonDescriptionById(Integer.toString(i16), Integer.toString(i3));
                            }
                            if (android.text.TextUtils.isEmpty(str2)) {
                                str2 = AbsQQText.SMALL_EMOJI_SYMBOL;
                            }
                            sb5.replace(i17, i17 + 5, str2);
                            length = str2.length();
                        }
                    }
                } else {
                    if ('\u00fa' == charAt) {
                        charAt = '\n';
                    }
                    String faceDescription = QQSysFaceUtil.getFaceDescription(charAt);
                    sb5.replace(i17, i17 + 2, faceDescription);
                    length = faceDescription.length();
                }
                i17 += length - 1;
            }
            i17++;
        }
        return sb5.toString();
    }

    public static String adjustEllipsizeEndText(TextView textView, String str, int i3) {
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        textView.getLayout();
        int desiredWidth = (i3 - ((int) Layout.getDesiredWidth(MiniBoxNoticeInfo.APPNAME_SUFFIX, textView.getPaint()))) - 1;
        int codePointCount = str.codePointCount(0, str.length());
        int length = str.length();
        float desiredWidth2 = Layout.getDesiredWidth(str.subSequence(0, length), textView.getPaint());
        while (true) {
            int i16 = ((int) desiredWidth2) + 1;
            if (codePointCount <= 0 || i16 <= desiredWidth) {
                break;
            }
            codePointCount--;
            length = str.offsetByCodePoints(0, codePointCount);
            desiredWidth2 = Layout.getDesiredWidth(str.subSequence(0, length), textView.getPaint());
        }
        if (length == str.length()) {
            return str;
        }
        return str.substring(0, length) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
    }

    public static final void backspace(EditText editText) {
        int i3;
        try {
            Editable text = editText.getText();
            int selectionStart = editText.getSelectionStart();
            if (selectionStart > 1) {
                i3 = android.text.TextUtils.getOffsetBefore(editText.getText(), selectionStart);
            } else {
                i3 = 0;
            }
            if (selectionStart != i3) {
                text.delete(Math.min(selectionStart, i3), Math.max(selectionStart, i3));
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static String cToe(String str) {
        String[] strArr = {"\uff01", "\uff0c", "\u3002", "\uff1b", "~", "\u300a", "\u300b", "\uff08", "\uff09", "\uff1f", "\u201d", "\uff5b", "\uff5d", "\u201c", "\uff1a", "\u3010", "\u3011", "\u201d", "\u2018", "\u2019", "!", ",", ".", ";", "`", "<", ">", "(", ")", QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, "'", "{", "}", "\"", ":", "{", "}", "\"", "'", "'"};
        String str2 = str;
        for (int i3 = 0; i3 < 20; i3++) {
            str2 = str2.replaceAll(strArr[i3], strArr[i3 + 20]);
        }
        return str2;
    }

    public static String emoticonToText(String str) {
        int length;
        int i3;
        int i16;
        String str2;
        int i17;
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        int emojiCount = QQEmojiUtil.getEmojiCount();
        for (int i18 = 0; i18 < emojiCount; i18++) {
            int indexOf = str.indexOf(QQEmojiUtil.getEmojiUnicode(i18), 0);
            if (indexOf != -1 && (i17 = indexOf + 2) <= str.length()) {
                str = str.replace(str.substring(indexOf, i17), QQEmojiUtil.getEmojiDescription(i18));
            }
        }
        if (!hasSysEmotion(str)) {
            return str;
        }
        StringBuilder sb5 = new StringBuilder(str);
        IEmoticonManager emoMgr = getEmoMgr();
        int i19 = 0;
        while (i19 < sb5.length()) {
            if (sb5.codePointAt(i19) == 20 && i19 < sb5.length() - 1) {
                int i26 = i19 + 1;
                char charAt = sb5.charAt(i26);
                if (QQSysFaceUtil.isValidFaceId(charAt)) {
                    String faceDescription = QQSysFaceUtil.getFaceDescription(charAt);
                    sb5.replace(i19, i19 + 2, faceDescription);
                    length = faceDescription.length();
                } else if (charAt == '\u00ff') {
                    int i27 = i19 + 4;
                    if (i27 >= sb5.length()) {
                        String str3 = AbsQQText.SMALL_EMOJI_SYMBOL;
                        sb5.replace(i19, sb5.length(), str3);
                        i19 += str3.length() - 1;
                    } else {
                        char[] cArr = new char[4];
                        cArr[0] = sb5.charAt(i27);
                        cArr[1] = sb5.charAt(i19 + 3);
                        cArr[2] = sb5.charAt(i19 + 2);
                        cArr[3] = sb5.charAt(i26);
                        for (int i28 = 0; i28 < 3; i28++) {
                            char c16 = cArr[i28];
                            if (c16 == '\u00fa') {
                                cArr[i28] = '\n';
                            } else if (c16 == '\u00fe') {
                                cArr[i28] = '\r';
                            }
                        }
                        int[] emoDescripFromChars = QQSmallEmoUtils.getEmoDescripFromChars(cArr);
                        if (emoDescripFromChars != null && emoDescripFromChars.length == 2) {
                            i16 = emoDescripFromChars[0];
                            i3 = emoDescripFromChars[1];
                        } else {
                            i3 = 0;
                            i16 = 0;
                        }
                        if (emoMgr == null) {
                            str2 = "";
                        } else {
                            str2 = emoMgr.getSmallEmoticonDescription(Integer.toString(i16), Integer.toString(i3));
                        }
                        if (android.text.TextUtils.isEmpty(str2)) {
                            str2 = AbsQQText.SMALL_EMOJI_SYMBOL;
                        }
                        sb5.replace(i19, i19 + 5, str2);
                        length = str2.length();
                    }
                }
                i19 += length - 1;
            }
            i19++;
        }
        return sb5.toString();
    }

    public static String emoticonToTextForTalkBack(String str) {
        int length;
        int i3;
        int i16;
        String str2;
        int i17;
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        int i18 = 0;
        while (true) {
            int i19 = 2;
            if (i18 >= FACE_REPLACE_NUM) {
                break;
            }
            int indexOf = str.indexOf(EmotcationConstants.EMOJI_CODES[i18], 0);
            if (indexOf != -1 && indexOf < str.length()) {
                if (str.codePointAt(indexOf) <= 65535) {
                    i19 = 1;
                }
                if (indexOf != -1 && (i17 = i19 + indexOf) <= str.length()) {
                    str = str.replace(str.substring(indexOf, i17), EmotcationConstants.getEmojiDesc(i18));
                }
            }
            i18++;
        }
        if (!hasSysEmotion(str)) {
            return str;
        }
        StringBuilder sb5 = new StringBuilder(str);
        IEmoticonManager emoMgr = getEmoMgr();
        int i26 = 0;
        boolean z16 = false;
        while (i26 < sb5.length()) {
            if (sb5.codePointAt(i26) == 20 && i26 < sb5.length() - 1) {
                int i27 = i26 + 1;
                char charAt = sb5.charAt(i27);
                if (charAt == '\u00fa') {
                    charAt = '\n';
                }
                if (QQSysFaceUtil.isValidFaceId(charAt)) {
                    String faceDescription = QQSysFaceUtil.getFaceDescription(charAt);
                    if (!z16) {
                        faceDescription = HardCodeUtil.qqStr(R.string.f230186yg) + faceDescription;
                    }
                    sb5.replace(i26, i26 + 2, faceDescription);
                    length = faceDescription.length();
                } else if (charAt == '\u00ff') {
                    int i28 = i26 + 4;
                    if (i28 >= sb5.length()) {
                        String str3 = AbsQQText.SMALL_EMOJI_SYMBOL;
                        sb5.replace(i26, sb5.length(), str3);
                        i26 += str3.length() - 1;
                    } else {
                        char[] cArr = new char[4];
                        cArr[0] = sb5.charAt(i28);
                        cArr[1] = sb5.charAt(i26 + 3);
                        cArr[2] = sb5.charAt(i26 + 2);
                        cArr[3] = sb5.charAt(i27);
                        for (int i29 = 0; i29 < 3; i29++) {
                            char c16 = cArr[i29];
                            if (c16 == '\u00fa') {
                                cArr[i29] = '\n';
                            } else if (c16 == '\u00fe') {
                                cArr[i29] = '\r';
                            }
                        }
                        int[] emoDescripFromChars = QQSmallEmoUtils.getEmoDescripFromChars(cArr);
                        if (emoDescripFromChars != null && emoDescripFromChars.length == 2) {
                            i16 = emoDescripFromChars[0];
                            i3 = emoDescripFromChars[1];
                        } else {
                            i3 = 0;
                            i16 = 0;
                        }
                        if (emoMgr == null) {
                            str2 = "";
                        } else {
                            str2 = emoMgr.syncGetEmoticonDescriptionById(Integer.toString(i16), Integer.toString(i3));
                        }
                        if (android.text.TextUtils.isEmpty(str2)) {
                            str2 = AbsQQText.SMALL_EMOJI_SYMBOL;
                        }
                        sb5.replace(i26, i26 + 5, str2);
                        length = str2.length();
                    }
                } else {
                    z16 = true;
                }
                i26 += length - 1;
                z16 = true;
            } else {
                z16 = false;
            }
            i26++;
        }
        return sb5.toString();
    }

    public static String emoticonToTextWithoutSysEmotion(String str) {
        int length;
        int i3;
        int i16;
        String str2;
        StringBuilder sb5 = new StringBuilder(str);
        IEmoticonManager emoMgr = getEmoMgr();
        int i17 = 0;
        while (i17 < sb5.length()) {
            if (sb5.codePointAt(i17) == 20 && i17 < sb5.length() - 1) {
                int i18 = i17 + 1;
                char charAt = sb5.charAt(i18);
                if (QQSysFaceUtil.isValidFaceId(charAt)) {
                    String faceDescription = QQSysFaceUtil.getFaceDescription(charAt);
                    sb5.replace(i17, i17 + 2, faceDescription);
                    length = faceDescription.length();
                } else if (charAt == '\u00ff') {
                    int i19 = i17 + 4;
                    if (i19 >= sb5.length()) {
                        String str3 = AbsQQText.SMALL_EMOJI_SYMBOL;
                        sb5.replace(i17, sb5.length(), str3);
                        i17 += str3.length() - 1;
                    } else {
                        char[] cArr = new char[4];
                        cArr[0] = sb5.charAt(i19);
                        cArr[1] = sb5.charAt(i17 + 3);
                        cArr[2] = sb5.charAt(i17 + 2);
                        cArr[3] = sb5.charAt(i18);
                        for (int i26 = 0; i26 < 3; i26++) {
                            char c16 = cArr[i26];
                            if (c16 == '\u00fa') {
                                cArr[i26] = '\n';
                            } else if (c16 == '\u00fe') {
                                cArr[i26] = '\r';
                            }
                        }
                        int[] emoDescripFromChars = QQSmallEmoUtils.getEmoDescripFromChars(cArr);
                        if (emoDescripFromChars != null && emoDescripFromChars.length == 2) {
                            i16 = emoDescripFromChars[0];
                            i3 = emoDescripFromChars[1];
                        } else {
                            i3 = 0;
                            i16 = 0;
                        }
                        if (emoMgr != null) {
                            str2 = emoMgr.getSmallEmoticonDescription(Integer.toString(i16), Integer.toString(i3));
                        } else {
                            str2 = "";
                        }
                        if (android.text.TextUtils.isEmpty(str2)) {
                            str2 = AbsQQText.SMALL_EMOJI_SYMBOL;
                        }
                        sb5.replace(i17, i17 + 5, str2);
                        length = str2.length();
                    }
                }
                i17 += length - 1;
            }
            i17++;
        }
        return sb5.toString();
    }

    public static void fixTextViewANRForAnd10(TextView textView) {
        if (Build.VERSION.SDK_INT >= 29 && !CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HUAWEI.equalsIgnoreCase(Build.MANUFACTURER)) {
            try {
                textView.setBreakStrategy(0);
            } catch (Throwable th5) {
                QLog.e(TAG, 1, th5, new Object[0]);
            }
        }
    }

    public static String getColorNickSysEmoticonString(int i3) {
        return String.valueOf(new char[]{Typography.less, '$', (char) QQSysFaceUtil.convertToServer(i3), Typography.greater});
    }

    private static IEmoticonManager getEmoMgr() {
        try {
            return (IEmoticonManager) MobileQQ.sMobileQQ.getAppRuntime(MobileQQ.sMobileQQ.getLastLoginUin()).getRuntimeService(IEmoticonManager.class, "all");
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static Drawable getEmojiDrawable(int i3) {
        if (i3 < 0) {
            QLog.e(TAG, 1, new IllegalArgumentException("[getEmojiDrawable] invalidate face index=" + i3), new Object[0]);
            return null;
        }
        int i16 = EmotcationConstants.INVALID_EMOJ_RES;
        if (i3 >= 1000) {
            return QQEmojiUtil.loadEmojiFromDisk(BaseApplication.getContext().getResources(), i3);
        }
        if (i3 < EmotcationConstants.VALID_EMOJI_COUNT) {
            i16 = EmotcationConstants.FIRST_EMOJI_RES + i3;
        }
        return getResourceDrawableThroughImageCache(BaseApplication.getContext().getResources(), i16);
    }

    public static final String getEmojiString(int i3) {
        if (i3 >= 0) {
            int[] iArr = EmotcationConstants.EMOJI_CODES;
            if (i3 < iArr.length) {
                return String.valueOf(Character.toChars(iArr[i3]));
            }
        }
        QLog.e(TAG, 1, new IllegalArgumentException("[getFaceGifDrawable] invalidate face localId=" + i3), new Object[0]);
        return "";
    }

    public static String getNeoTextAfter(String str, int i3, int i16, boolean z16) {
        int i17;
        int i18;
        int i19 = (i16 * 4) + i3;
        if (i19 > str.length()) {
            i19 = str.length();
        }
        int i26 = i3;
        int i27 = 0;
        while (i26 < i19) {
            int codePointAt = str.codePointAt(i26);
            if (codePointAt == 20 && (i17 = i26 + 1) < i19) {
                if (str.charAt(i17) < '\u00ff' || (i18 = i26 + 4) >= i19) {
                    i18 = i26 + 2;
                }
                i26 = i18;
            } else {
                i26 += Character.charCount(codePointAt);
            }
            i27++;
            if (i27 >= i16) {
                break;
            }
        }
        if (i27 < i16) {
            i26 = i3;
        } else if (i26 > str.length()) {
            i26 = str.length();
        }
        String substring = str.substring(i3, i26);
        if (z16) {
            if (substring.contains("\n") || substring.contains("\r")) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "cutString=", substring);
                }
                return "";
            }
            return substring;
        }
        return substring;
    }

    public static String getNeoTextBefore(String str, int i3, int i16) {
        int i17;
        int i18;
        int i19;
        int i26 = i3 - (i16 * 4);
        int i27 = 0;
        if (i26 <= 0) {
            i26 = 0;
        }
        SparseArray sparseArray = new SparseArray();
        int i28 = 0;
        while (i26 < i3) {
            sparseArray.put(i28, Integer.valueOf(i26));
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getNeoTextBefore subStringLength= ", Integer.valueOf(i26), " end:", Integer.valueOf(i3));
            }
            int codePointAt = str.codePointAt(i26);
            if (codePointAt == 20 && (i18 = i26 + 1) < i3) {
                if (str.charAt(i18) < '\u00ff' || (i19 = i26 + 4) >= i3) {
                    i19 = i26 + 2;
                }
                i26 = i19;
            } else {
                i26 += Character.charCount(codePointAt);
            }
            i28++;
        }
        if (sparseArray.size() - i16 >= 0) {
            i17 = ((Integer) sparseArray.get(sparseArray.size() - i16)).intValue();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getNeoTextBefore from Array subStringLength= ", Integer.valueOf(i17), " loopTime - maxContentLength:", Integer.valueOf(sparseArray.size() - i16));
            }
        } else {
            i17 = i3;
        }
        if (i17 >= 0) {
            i27 = i17;
        }
        return str.substring(i27, i3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0044, code lost:
    
        if (r4 == '\u00fa') goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int getQQTextCharCount(String str, int i3) {
        int codePointAt;
        int i16;
        boolean z16;
        boolean z17;
        boolean z18;
        if (str == null || str.length() == 0) {
            return 0;
        }
        int length = str.length();
        int i17 = 0;
        int i18 = 0;
        while (i17 < length) {
            int codePointAt2 = str.codePointAt(i17);
            int i19 = 2;
            int i26 = 1;
            if ((i3 & 6) > 0 && codePointAt2 == 20 && i17 < length - 1) {
                char charAt = str.charAt(i17 + 1);
                if (!QQSysFaceUtil.isValidFaceId(charAt)) {
                    if (charAt >= '\u00ff' && i17 + 4 < length) {
                        i18++;
                        i19 = 4;
                        z18 = true;
                        if (z18) {
                        }
                        i17 += i26;
                    }
                }
                i18++;
                z18 = true;
                if (z18) {
                }
                i17 += i26;
            } else {
                if ((i3 & 1) == 1) {
                    int singleEmoji = EmotcationConstants.getSingleEmoji(codePointAt2);
                    if (codePointAt2 > 65535) {
                        int i27 = i17 + 2;
                        if (length > i27) {
                            codePointAt = str.codePointAt(i27);
                            z16 = false;
                        }
                        z16 = false;
                        codePointAt = -1;
                    } else {
                        int i28 = i17 + 1;
                        if (length > i28) {
                            codePointAt = str.codePointAt(i28);
                            if (codePointAt == 65039 && length > (i16 = i17 + 2)) {
                                codePointAt = str.codePointAt(i16);
                                z16 = true;
                            }
                            z16 = false;
                        }
                        z16 = false;
                        codePointAt = -1;
                    }
                    boolean isSkinEmoji = EmotcationConstants.isSkinEmoji(codePointAt);
                    if (singleEmoji != -1 && !isSkinEmoji) {
                        z17 = false;
                    } else {
                        int doubleEmoji = EmotcationConstants.getDoubleEmoji(codePointAt2, codePointAt);
                        if (doubleEmoji != -1) {
                            singleEmoji = doubleEmoji;
                        }
                        z17 = true;
                    }
                    if (singleEmoji != -1) {
                        if (z17) {
                            if (codePointAt2 <= 65535 || length < i17 + 2) {
                                i19 = 1;
                            }
                            if (codePointAt > 65535 && length >= i17 + 2) {
                                i19 += 2;
                            } else {
                                i19++;
                            }
                            if (z16) {
                                i19++;
                            }
                        } else if (codePointAt2 <= 65535 || length < i17 + 2) {
                            i19 = 1;
                        }
                        i18++;
                        z18 = true;
                        if (z18) {
                            i18++;
                        } else {
                            i26 = i19;
                        }
                        i17 += i26;
                    }
                }
                z18 = false;
                i19 = 0;
                if (z18) {
                }
                i17 += i26;
            }
        }
        return i18;
    }

    public static Drawable getResourceDrawableThroughImageCache(Resources resources, int i3) {
        String str = "android.resource://" + i3;
        ImageCacheHelper imageCacheHelper = ImageCacheHelper.f98636a;
        Object g16 = imageCacheHelper.g(str);
        if (g16 instanceof com.tencent.cache.api.g) {
            return ((Drawable.ConstantState) ((com.tencent.cache.api.g) g16).b()).newDrawable(resources);
        }
        try {
            Drawable drawable = resources.getDrawable(i3);
            int e16 = cn.e(drawable);
            if (e16 > 0) {
                imageCacheHelper.i(str, new com.tencent.cache.api.g(drawable.getConstantState(), e16), Business.Conversation);
            }
            return drawable;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getStringWithoutEmoji(String str) {
        int hasEmoji = hasEmoji(str);
        while (hasEmoji != -1) {
            int i3 = hasEmoji + 2;
            if (i3 > str.length()) {
                i3 = str.length();
            }
            str = str.replace(str.substring(hasEmoji, i3), "");
            hasEmoji = hasEmoji(str);
        }
        return str;
    }

    public static final String getSysEmotcationDisplayString(int i3) {
        return QQSysFaceUtil.getFaceDescription(i3);
    }

    public static final Drawable getSysEmotcationDrawable(int i3, boolean z16) {
        if (!z16) {
            return QQSysFaceUtil.getFaceDrawable(i3);
        }
        return QQSysFaceUtil.getFaceGifDrawable(i3);
    }

    public static final String getSysEmotcationString(int i3) {
        return QQSysFaceUtil.getFaceString(i3);
    }

    public static String getTextWithoutEmoji(String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        int length = str.length();
        String str2 = "";
        int i3 = 0;
        while (i3 < length) {
            if (str.codePointAt(i3) == 20) {
                if (i3 < length - 1) {
                    int i16 = i3 + 1;
                    if (str.charAt(i16) < '\u00ff') {
                        i3 = i16;
                    } else {
                        i3 += 4;
                    }
                }
            } else {
                str2 = str2 + str.charAt(i3);
            }
            i3++;
        }
        return str2;
    }

    public static boolean hasChnChar(CharSequence charSequence) {
        for (int i3 = 0; i3 < charSequence.length(); i3++) {
            int parseInt = Integer.parseInt(Integer.toHexString(charSequence.charAt(i3)), 16);
            if (parseInt >= 19968 && parseInt <= 40891) {
                return true;
            }
        }
        return false;
    }

    public static int hasEmoji(String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return -1;
        }
        for (int i3 = 0; i3 < str.length(); i3++) {
            char charAt = str.charAt(i3);
            if (charAt >= '\u2100' && charAt <= '\u27ff') {
                return i3;
            }
            if (charAt >= '\u2934' && charAt <= '\u2935') {
                return i3;
            }
            if (charAt >= '\u2b05' && charAt <= '\u2b07') {
                return i3;
            }
            if (charAt >= '\u2b1b' && charAt <= '\u2b1c') {
                return i3;
            }
            if (charAt != '\u00a9' && charAt != '\u00ae' && charAt != '\u203c' && charAt != '\u2049' && charAt != '\u2b50' && charAt != '\u2b55' && charAt != '\u3030' && charAt != '\u303d' && charAt != '\u3297' && charAt != '\u3299') {
                if (charAt >= '\ud800' && charAt <= '\udbff' && i3 < str.length() - 1) {
                    char charAt2 = str.charAt(i3 + 1);
                    if (charAt2 >= '\udc00' && charAt2 <= '\udfff') {
                        return i3;
                    }
                } else if (charAt == '\u20e3') {
                    return i3;
                }
            } else {
                return i3;
            }
        }
        return -1;
    }

    public static boolean hasSysEmotion(String str) {
        if (android.text.TextUtils.isEmpty(str) || -1 == str.indexOf(20)) {
            return false;
        }
        return true;
    }

    public static String hideUinInShowString(String str, int i3) {
        String substring;
        if (str != null && str.length() != 0) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("**");
            if (i3 >= str.length()) {
                substring = "-";
            } else {
                substring = str.substring(i3);
            }
            sb5.append(substring);
            return sb5.toString();
        }
        return "null";
    }

    public static boolean isAllSystemEmotcation(String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        int i3 = 0;
        while (i3 < str.length()) {
            int codePointAt = str.codePointAt(i3);
            if (20 == codePointAt) {
                i3++;
            } else if (32 != codePointAt) {
                return false;
            }
            i3++;
        }
        return true;
    }

    public static boolean isApolloEmoticon(int i3) {
        return QQSysFaceUtil.isApolloEmoticon(i3);
    }

    public static boolean isContainComplexScript(String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        int length = str.length();
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            if (charAt < '\u0600' || charAt > '\u06ff') {
                if (charAt < '\u0750' || charAt > '\u077f') {
                    if (charAt < '\ufb50' || charAt > '\ufdff') {
                        if (charAt >= '\ufe70' && charAt <= '\ufeff') {
                            return true;
                        }
                    } else {
                        return true;
                    }
                } else {
                    return true;
                }
            } else {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getEmojiDrawable$0(int i3, LoadSysEmojiCallback loadSysEmojiCallback) {
        Drawable resourceDrawableThroughImageCache = getResourceDrawableThroughImageCache(BaseApplication.getContext().getResources(), i3);
        if (resourceDrawableThroughImageCache != null && loadSysEmojiCallback != null) {
            loadSysEmojiCallback.callbackWhenSysEmojiLoaded(resourceDrawableThroughImageCache);
        }
    }

    public static String removeColorNickCode(String str) {
        char charAt;
        int indexOf;
        if (!android.text.TextUtils.isEmpty(str) && str.length() >= 5) {
            int length = str.length();
            StringBuilder sb5 = new StringBuilder();
            int i3 = 0;
            while (i3 < length) {
                char charAt2 = str.charAt(i3);
                if (charAt2 == '<' && i3 < length - 2 && (((charAt = str.charAt(i3 + 1)) == '$' || charAt == '%' || charAt == '&') && i3 < length - 5 && (indexOf = str.indexOf(62, i3)) != -1)) {
                    i3 += indexOf;
                } else {
                    sb5.append(charAt2);
                }
                i3++;
            }
            return sb5.toString();
        }
        return str;
    }

    public static String replaceEmojiWithSpace(String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        int length = str.length();
        String str2 = "";
        int i3 = 0;
        while (i3 < length) {
            if (str.codePointAt(i3) == 20) {
                if (i3 < length - 1) {
                    int i16 = i3 + 1;
                    if (str.charAt(i16) < '\u00ff') {
                        str2 = str2 + "  ";
                        i3 = i16;
                    } else {
                        str2 = str2 + "     ";
                        i3 += 4;
                    }
                }
            } else {
                str2 = str2 + str.charAt(i3);
            }
            i3++;
        }
        return str2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x005e, code lost:
    
        if (r7 == '\u00fa') goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0097 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String subQQTextString(String str, Paint paint, int i3, int i16, int i17, boolean z16) {
        int codePointAt;
        int i18;
        boolean z17;
        int doubleEmoji;
        boolean z18;
        int i19;
        int i26;
        int i27;
        boolean z19;
        if (str != null && str.length() != 0) {
            if (paint == null) {
                return str;
            }
            int length = str.length();
            int dip2px = ViewUtils.dip2px(i16);
            StringBuilder sb5 = new StringBuilder();
            int i28 = 0;
            int i29 = 0;
            int i36 = 0;
            int i37 = 0;
            while (i28 < length && i29 < i17) {
                int codePointAt2 = str.codePointAt(i28);
                if ((i3 & 6) > 0 && codePointAt2 == 20 && i28 < length - 1) {
                    char charAt = str.charAt(i28 + 1);
                    if (!QQSysFaceUtil.isValidFaceId(charAt)) {
                        if (charAt >= '\u00ff' && i28 + 4 < length) {
                            i37++;
                            i19 = 4;
                            z19 = true;
                        }
                    }
                    i37++;
                    z19 = true;
                    i19 = 2;
                } else {
                    if ((i3 & 1) == 1) {
                        int singleEmoji = EmotcationConstants.getSingleEmoji(codePointAt2);
                        if (codePointAt2 > 65535) {
                            int i38 = i28 + 2;
                            if (length > i38) {
                                codePointAt = str.codePointAt(i38);
                                z17 = false;
                                boolean isSkinEmoji = EmotcationConstants.isSkinEmoji(codePointAt);
                                if (singleEmoji == -1 && !isSkinEmoji) {
                                    z18 = false;
                                } else {
                                    doubleEmoji = EmotcationConstants.getDoubleEmoji(codePointAt2, codePointAt);
                                    if (doubleEmoji != -1) {
                                        singleEmoji = doubleEmoji;
                                    }
                                    z18 = true;
                                }
                                if (singleEmoji != -1) {
                                    if (z18) {
                                        if (codePointAt2 > 65535 && length >= i28 + 2) {
                                            i26 = 2;
                                        } else {
                                            i26 = 1;
                                        }
                                        if (codePointAt > 65535 && length >= i28 + 2) {
                                            i27 = i26 + 2;
                                        } else {
                                            i27 = i26 + 1;
                                        }
                                        if (z17) {
                                            i27++;
                                        }
                                        i19 = i27;
                                    } else if (codePointAt2 > 65535 && length >= i28 + 2) {
                                        i19 = 2;
                                    } else {
                                        i19 = 1;
                                    }
                                    i37++;
                                    z19 = true;
                                }
                            }
                            codePointAt = -1;
                            z17 = false;
                            boolean isSkinEmoji2 = EmotcationConstants.isSkinEmoji(codePointAt);
                            if (singleEmoji == -1) {
                            }
                            doubleEmoji = EmotcationConstants.getDoubleEmoji(codePointAt2, codePointAt);
                            if (doubleEmoji != -1) {
                            }
                            z18 = true;
                            if (singleEmoji != -1) {
                            }
                        } else {
                            int i39 = i28 + 1;
                            if (length > i39) {
                                codePointAt = str.codePointAt(i39);
                                if (codePointAt == 65039 && length > (i18 = i28 + 2)) {
                                    codePointAt = str.codePointAt(i18);
                                    z17 = true;
                                    boolean isSkinEmoji22 = EmotcationConstants.isSkinEmoji(codePointAt);
                                    if (singleEmoji == -1) {
                                    }
                                    doubleEmoji = EmotcationConstants.getDoubleEmoji(codePointAt2, codePointAt);
                                    if (doubleEmoji != -1) {
                                    }
                                    z18 = true;
                                    if (singleEmoji != -1) {
                                    }
                                }
                                z17 = false;
                                boolean isSkinEmoji222 = EmotcationConstants.isSkinEmoji(codePointAt);
                                if (singleEmoji == -1) {
                                }
                                doubleEmoji = EmotcationConstants.getDoubleEmoji(codePointAt2, codePointAt);
                                if (doubleEmoji != -1) {
                                }
                                z18 = true;
                                if (singleEmoji != -1) {
                                }
                            }
                            codePointAt = -1;
                            z17 = false;
                            boolean isSkinEmoji2222 = EmotcationConstants.isSkinEmoji(codePointAt);
                            if (singleEmoji == -1) {
                            }
                            doubleEmoji = EmotcationConstants.getDoubleEmoji(codePointAt2, codePointAt);
                            if (doubleEmoji != -1) {
                            }
                            z18 = true;
                            if (singleEmoji != -1) {
                            }
                        }
                    }
                    z19 = false;
                    i19 = 0;
                }
                if (!z19) {
                    sb5.append(str.charAt(i28));
                    i36 = 1;
                } else {
                    i36 = i19;
                }
                i29 = (int) (paint.measureText(sb5.toString()) + (i37 * dip2px) + 0.5f);
                i28 += i36;
            }
            if (i28 < length - 1 && z16) {
                return str.substring(0, i28 - i36) + "\u2026";
            }
            return str.substring(0, i28);
        }
        return "";
    }

    public static String trimNewLine(String str, boolean z16) {
        if (str != null && str.length() != 0) {
            int length = str.length();
            int i3 = 0;
            if (z16) {
                while (i3 < length && str.charAt(i3) == '\n') {
                    i3++;
                }
            } else {
                while (length > 0 && str.charAt(length - 1) == '\n') {
                    length--;
                }
            }
            if (i3 > 0 || length < str.length()) {
                return str.substring(i3, length);
            }
            return str;
        }
        return str;
    }

    public static final Drawable getEmojiDrawable(int i3, final LoadSysEmojiCallback loadSysEmojiCallback) {
        if (i3 < 0) {
            QLog.e(TAG, 1, new IllegalArgumentException("[getEmojiDrawable with callback] invalidate face index=" + i3), new Object[0]);
            return null;
        }
        Resources resources = BaseApplication.getContext().getResources();
        final int i16 = EmotcationConstants.INVALID_EMOJ_RES;
        if (i3 >= 1000) {
            Object g16 = ImageCacheHelper.f98636a.g("emotion://" + i3);
            if (g16 instanceof com.tencent.cache.api.g) {
                return ((Drawable.ConstantState) ((com.tencent.cache.api.g) g16).b()).newDrawable(resources);
            }
            ThreadManagerV2.executeOnFileThread(new Runnable(i3, loadSysEmojiCallback) { // from class: com.tencent.mobileqq.text.TextUtils.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f292660d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ LoadSysEmojiCallback f292661e;

                {
                    this.f292660d = i3;
                    this.f292661e = loadSysEmojiCallback;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) loadSysEmojiCallback);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    LoadSysEmojiCallback loadSysEmojiCallback2;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    Drawable loadEmojiFromDisk = QQEmojiUtil.loadEmojiFromDisk(BaseApplication.getContext().getResources(), this.f292660d);
                    if (loadEmojiFromDisk != null && (loadSysEmojiCallback2 = this.f292661e) != null) {
                        loadSysEmojiCallback2.callbackWhenSysEmojiLoaded(loadEmojiFromDisk);
                    }
                }
            });
        } else {
            if (i3 < EmotcationConstants.VALID_EMOJI_COUNT) {
                i16 = EmotcationConstants.FIRST_EMOJI_RES + i3;
            }
            Object g17 = ImageCacheHelper.f98636a.g("android.resource://" + i16);
            if (g17 instanceof com.tencent.cache.api.g) {
                return ((Drawable.ConstantState) ((com.tencent.cache.api.g) g17).b()).newDrawable(resources);
            }
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.text.p
                @Override // java.lang.Runnable
                public final void run() {
                    TextUtils.lambda$getEmojiDrawable$0(i16, loadSysEmojiCallback);
                }
            }, 64, null, false);
        }
        return null;
    }
}
