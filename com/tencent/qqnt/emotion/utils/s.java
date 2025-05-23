package com.tencent.qqnt.emotion.utils;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.text.AbsQQText;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.qqnt.emotion.api.IEmoticonManager;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes24.dex */
public class s {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final int f356701a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43813);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f356701a = com.tencent.qqnt.emoji.a.EMOJI_CONTENT_DESC.length;
        }
    }

    public static String a(String str) {
        String[] strArr = {"\uff01", "\uff0c", "\u3002", "\uff1b", "~", "\u300a", "\u300b", "\uff08", "\uff09", "\uff1f", "\u201d", "\uff5b", "\uff5d", "\u201c", "\uff1a", "\u3010", "\u3011", "\u201d", "\u2018", "\u2019", "!", ",", ".", ";", "`", "<", ">", "(", ")", QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, "'", "{", "}", "\"", ":", "{", "}", "\"", "'", "'"};
        String str2 = str;
        for (int i3 = 0; i3 < 20; i3++) {
            str2 = str2.replaceAll(strArr[i3], strArr[i3 + 20]);
        }
        return str2;
    }

    public static String b(String str) {
        int length;
        int i3;
        int i16;
        String str2;
        int i17;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int i18 = 0;
        while (true) {
            int i19 = 2;
            if (i18 >= f356701a) {
                break;
            }
            int indexOf = str.indexOf(com.tencent.qqnt.emoji.a.EMOJI_CODES[i18], 0);
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
        if (!h(str)) {
            return str;
        }
        StringBuilder sb5 = new StringBuilder(str);
        IEmoticonManager f16 = f();
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
                        faceDescription = HardCodeUtil.qqStr(R.string.yet) + faceDescription;
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
                        int[] b16 = o.b(cArr);
                        if (b16 != null && b16.length == 2) {
                            i16 = b16[0];
                            i3 = b16[1];
                        } else {
                            i3 = 0;
                            i16 = 0;
                        }
                        if (f16 == null) {
                            str2 = "";
                        } else {
                            str2 = f16.syncGetEmoticonDescriptionById(Integer.toString(i16), Integer.toString(i3));
                        }
                        if (TextUtils.isEmpty(str2)) {
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

    public static String c(String str) {
        int length;
        int i3;
        int i16;
        String str2;
        StringBuilder sb5 = new StringBuilder(str);
        IEmoticonManager f16 = f();
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
                        int[] b16 = o.b(cArr);
                        if (b16 != null && b16.length == 2) {
                            i16 = b16[0];
                            i3 = b16[1];
                        } else {
                            i3 = 0;
                            i16 = 0;
                        }
                        if (f16 != null) {
                            str2 = f16.getSmallEmoticonDescription(Integer.toString(i16), Integer.toString(i3));
                        } else {
                            str2 = "";
                        }
                        if (TextUtils.isEmpty(str2)) {
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

    @SuppressLint({"NewApi"})
    public static int d(Bitmap bitmap) {
        if (bitmap == null) {
            return -1;
        }
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    private static int e(Drawable drawable) {
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return -1;
        }
        return d(((BitmapDrawable) drawable).getBitmap());
    }

    private static IEmoticonManager f() {
        try {
            return (IEmoticonManager) MobileQQ.sMobileQQ.getAppRuntime(MobileQQ.sMobileQQ.getLastLoginUin()).getRuntimeService(IEmoticonManager.class, "all");
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static Drawable g(Resources resources, int i3) {
        String str = "android.resource://" + i3;
        ImageCacheHelper imageCacheHelper = ImageCacheHelper.f98636a;
        Object g16 = imageCacheHelper.g(str);
        if (g16 instanceof com.tencent.cache.api.g) {
            return ((Drawable.ConstantState) ((com.tencent.cache.api.g) g16).b()).newDrawable(resources);
        }
        try {
            Drawable drawable = resources.getDrawable(i3);
            int e16 = e(drawable);
            if (e16 > 0) {
                imageCacheHelper.i(str, new com.tencent.cache.api.g(drawable.getConstantState(), e16), Business.Conversation);
            }
            return drawable;
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean h(String str) {
        if (TextUtils.isEmpty(str) || -1 == str.indexOf(20)) {
            return false;
        }
        return true;
    }
}
