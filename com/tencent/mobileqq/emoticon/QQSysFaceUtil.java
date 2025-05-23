package com.tencent.mobileqq.emoticon;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.config.business.ba;
import com.tencent.mobileqq.data.AniStickerInfo;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QQSysFaceUtil {
    static IPatchRedirector $redirector_ = null;
    public static int DEFAULT_ANIM_EMO_COUNT_ABOVE_ANDROID_O = 0;
    public static int DEFAULT_ANIM_EMO_COUNT_BELOW_ANDROID_O = 0;
    public static int MAX_ANIM_EMO_COUNT = 0;
    public static int MIN_ANIM_EMO_COUNT = 0;
    public static final int NEW_SYSFACE_INDEX = 260;
    private static int[] SYS_EMOTION_ORDER = null;
    private static final String SYS_FACE_NT_DOWNLOAD_SWITCH = "100151";
    public static final String TAG = "QQSysFaceUtil";
    private static int sAnimEmoCount;
    private static boolean sAnimEmoCountFlag;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41350);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        sAnimEmoCount = -1;
        sAnimEmoCountFlag = false;
        MIN_ANIM_EMO_COUNT = 10;
        MAX_ANIM_EMO_COUNT = 100;
        DEFAULT_ANIM_EMO_COUNT_BELOW_ANDROID_O = 20;
        DEFAULT_ANIM_EMO_COUNT_ABOVE_ANDROID_O = 30;
        SYS_EMOTION_ORDER = new int[]{23, 40, 19, 43, 21, 20, 106, 35, 10, 25, 24, 1, 0, 33, 32, 12, 27, 13, 22, 3, 18, 30, 31, 81, 82, 26, 2, 37, 50, 42, 83, 34, 11, 49, 84, 39, 78, 5, 4, 6, 85, 86, 87, 46, 88, 44, 89, 48, 14, 90, 41, 36, 91, 51, 164, 174, 171, 165, 166, 161, 167, 170, 169, 168, 175, 45, 28, 8, 57, 179, 118, 29, 74, 66, 177, 52, 64, 56, 54, 63, 55, 73, 72, 53, 94, 150, 7, 17, 70, 141, 163, 15, 116, 119, 60, 71, 97, 38, 95, 96, 79, 47};
    }

    public QQSysFaceUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void checkInitQQSysAndEmojiResMgr() {
        try {
            QQSysAndEmojiResMgr.getInstance();
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "[initQQSysAndEmojiResMgr]", th5);
        }
    }

    public static boolean containsExpression(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int i3 = 0; i3 < str.length(); i3++) {
            if (20 == str.codePointAt(i3)) {
                return true;
            }
        }
        return false;
    }

    public static int convertToLocal(int i3) {
        return QQSysAndEmojiResMgr.getInstance().getResImpl(1).getLocalId(i3);
    }

    public static int convertToServer(int i3) {
        return QQSysAndEmojiResMgr.getInstance().getResImpl(1).getServerId(i3);
    }

    public static ArrayList<Integer> getAllAniStickerOrderList() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.addAll(getAniStickerOrderList());
        arrayList.addAll(getExtAniStickerOrderList());
        arrayList.addAll(getFavoritePanelAniStickerOrderList());
        return arrayList;
    }

    @Nullable
    public static AniStickerInfo getAniStickerInfo(int i3) {
        return ((QQSysFaceResImpl) QQSysAndEmojiResMgr.getInstance().getResImpl(1)).getAniStickerInfo(i3, null, null);
    }

    public static Drawable getAniStickerLoadingDrawable(int i3, Drawable drawable) {
        if (!QQSysFaceSwitcher.f204652a.e()) {
            return drawable;
        }
        String aniStickerLoadingResPath = QQSysAndEmojiResMgr.getInstance().getAniStickerLoadingResPath(convertToServer(i3));
        if (FileUtils.fileExistsAndNotEmpty(aniStickerLoadingResPath)) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mLoadingDrawable = drawable;
            obtain.mFailedDrawable = drawable;
            return URLDrawable.getFileDrawable(aniStickerLoadingResPath, obtain);
        }
        return drawable;
    }

    public static ArrayList<Integer> getAniStickerOrderList() {
        return ((QQSysFaceResImpl) QQSysAndEmojiResMgr.getInstance().getResImpl(1)).getAniStickerOrderList();
    }

    public static int getAnimEmoCount() {
        if (sAnimEmoCount == -1) {
            long currentTimeMillis = System.currentTimeMillis();
            oa1.d c16 = ba.INSTANCE.c();
            if (c16 != null) {
                if (!TextUtils.isEmpty(c16.f422307n.f422274a)) {
                    sAnimEmoCountFlag = true;
                    sAnimEmoCount = parseAnimCountByModel(c16.f422307n.f422274a, DeviceInfoMonitor.getModel());
                }
                if (sAnimEmoCount == -1 && !TextUtils.isEmpty(c16.f422307n.f422275b)) {
                    sAnimEmoCountFlag = true;
                    sAnimEmoCount = parseAnimCountByVersion(c16.f422307n.f422275b, Build.VERSION.SDK_INT);
                }
            }
            QLog.d(TAG, 1, "animCount:", Integer.valueOf(sAnimEmoCount), ", parseCostTime = [", (System.currentTimeMillis() - currentTimeMillis) + "]");
        }
        if (sAnimEmoCount == -1) {
            if (Build.VERSION.SDK_INT <= 26) {
                sAnimEmoCount = DEFAULT_ANIM_EMO_COUNT_BELOW_ANDROID_O;
            } else {
                sAnimEmoCount = DEFAULT_ANIM_EMO_COUNT_ABOVE_ANDROID_O;
            }
        }
        int i3 = sAnimEmoCount;
        int i16 = MIN_ANIM_EMO_COUNT;
        if (i3 < i16) {
            sAnimEmoCount = i16;
        } else {
            int i17 = MAX_ANIM_EMO_COUNT;
            if (i3 > i17) {
                sAnimEmoCount = i17;
            }
        }
        return sAnimEmoCount;
    }

    public static String getEMCode(int i3) {
        QQSysAndEmojiResInfo resImpl = QQSysAndEmojiResMgr.getInstance().getResImpl(1);
        if (resImpl instanceof QQSysFaceResImpl) {
            return ((QQSysFaceResImpl) resImpl).getEMCode(i3);
        }
        return null;
    }

    public static ArrayList<Integer> getExtAniStickerOrderList() {
        return ((QQSysFaceResImpl) QQSysAndEmojiResMgr.getInstance().getResImpl(1)).getExtAniStickerOrderList();
    }

    public static String getFaceDescription(int i3) {
        String description = QQSysAndEmojiResMgr.getInstance().getResImpl(1).getDescription(i3);
        if (TextUtils.isEmpty(description)) {
            String[] strArr = EmotcationConstants.SYS_EMOTICON_SYMBOL;
            if (i3 < strArr.length && i3 >= 0) {
                return strArr[i3];
            }
            return description;
        }
        return description;
    }

    public static Drawable getFaceDrawable(int i3) {
        if (i3 < 0) {
            QLog.e(TAG, 1, new IllegalArgumentException("[getFaceDrawable] invalidate face localId=" + i3), new Object[0]);
            return null;
        }
        Drawable drawable = QQSysAndEmojiResMgr.getInstance().getResImpl(1).getDrawable(i3);
        if (drawable == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "face not found, use local res, id=" + i3);
            }
            return getFaceDrawableFromLocal(i3);
        }
        return drawable;
    }

    public static Drawable getFaceDrawableFromLocal(int i3) {
        if (i3 >= 0 && i3 < EmotcationConstants.VALID_SYS_EMOTCATION_COUNT) {
            return com.tencent.qqnt.emotion.utils.s.g(BaseApplication.getContext().getResources(), EmotcationConstants.STATIC_SYS_EMOTCATION_RESOURCE[i3]);
        }
        return null;
    }

    public static Drawable getFaceGifDrawable(int i3) {
        if (i3 < 0) {
            QLog.e(TAG, 1, new IllegalArgumentException("[getFaceGifDrawable] invalidate face localId=" + i3), new Object[0]);
            return null;
        }
        QQSysAndEmojiResInfo resImpl = QQSysAndEmojiResMgr.getInstance().getResImpl(1);
        if (!(resImpl instanceof QQSysFaceResImpl)) {
            return null;
        }
        return ((QQSysFaceResImpl) resImpl).getGifDrawable(i3);
    }

    @Deprecated
    public static Drawable getFaceGifURLDrawable(int i3) {
        if (i3 < 0) {
            QLog.e(TAG, 1, new IllegalArgumentException("[getFaceGifDrawable] invalidate face localId=" + i3), new Object[0]);
            return null;
        }
        QQSysAndEmojiResInfo resImpl = QQSysAndEmojiResMgr.getInstance().getResImpl(1);
        if (!(resImpl instanceof QQSysFaceResImpl)) {
            return null;
        }
        return ((QQSysFaceResImpl) resImpl).getGifURLDrawable(i3);
    }

    public static final String getFaceString(int i3) {
        return String.valueOf(new char[]{20, (char) i3});
    }

    public static ArrayList<Integer> getFavoritePanelAniStickerOrderList() {
        return ((QQSysFaceResImpl) QQSysAndEmojiResMgr.getInstance().getResImpl(1)).getFavPanelAniStickerOrderList();
    }

    public static ArrayList<Integer> getFullFaceCodeList() {
        ArrayList<Integer> fullFaceCodeList = QQSysAndEmojiResMgr.getInstance().getResImpl(1).getFullFaceCodeList();
        if (fullFaceCodeList != null && fullFaceCodeList.size() > 0) {
            return fullFaceCodeList;
        }
        return getOrderList();
    }

    public static int getLocalIdFromEMCode(String str) {
        int i3;
        QQSysAndEmojiResInfo resImpl = QQSysAndEmojiResMgr.getInstance().getResImpl(1);
        if (resImpl instanceof QQSysFaceResImpl) {
            i3 = ((QQSysFaceResImpl) resImpl).getLocalIdFromEMCode(str);
        } else {
            i3 = -1;
        }
        if (i3 == -1 && QQSysFaceSwitcher.f204652a.s()) {
            return convertToLocal(q.f(str));
        }
        return i3;
    }

    public static ArrayList<Integer> getOrderList() {
        ArrayList<Integer> orderList = QQSysAndEmojiResMgr.getInstance().getResImpl(1).getOrderList();
        if (orderList != null && orderList.size() > 0) {
            return orderList;
        }
        QLog.w(TAG, 1, "[getOrderList] use local default sysface orderList.");
        int[] iArr = SYS_EMOTION_ORDER;
        ArrayList<Integer> arrayList = new ArrayList<>(iArr.length);
        for (int i3 : iArr) {
            arrayList.add(Integer.valueOf(i3));
        }
        return arrayList;
    }

    public static String getPrueFaceDescription(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("/")) {
            return str.substring(1);
        }
        return str;
    }

    public static boolean isApolloEmoticon(int i3) {
        QQSysAndEmojiResInfo resImpl = QQSysAndEmojiResMgr.getInstance().getResImpl(1);
        if (resImpl instanceof QQSysFaceResImpl) {
            return ((QQSysFaceResImpl) resImpl).isCMEmoji(i3);
        }
        return false;
    }

    public static boolean isBigStickerById(int i3) {
        return isBigStickerByType(((QQSysFaceResImpl) QQSysAndEmojiResMgr.getInstance().getResImpl(1)).getAniStickerType(i3));
    }

    public static boolean isBigStickerByType(int i3) {
        if (i3 == 1 || i3 == 2 || i3 == 3) {
            return true;
        }
        return false;
    }

    public static boolean isEmoReady(int i3) {
        return QQSysAndEmojiResMgr.getInstance().getResImpl(1).isResReady(i3);
    }

    public static boolean isRandomAniSticker(int i3) {
        return isRandomAniStickerByType(((QQSysFaceResImpl) QQSysAndEmojiResMgr.getInstance().getResImpl(1)).getAniStickerType(i3));
    }

    public static boolean isRandomAniStickerByType(int i3) {
        if (i3 != 2 && i3 != 3) {
            return false;
        }
        return true;
    }

    public static boolean isRandomChainSticker(int i3) {
        if (((QQSysFaceResImpl) QQSysAndEmojiResMgr.getInstance().getResImpl(1)).getAniStickerType(i3) == 3) {
            return true;
        }
        return false;
    }

    public static boolean isStaticFace(int i3) {
        QQSysAndEmojiResInfo resImpl = QQSysAndEmojiResMgr.getInstance().getResImpl(1);
        if (resImpl instanceof QQSysFaceResImpl) {
            try {
                return ((QQSysFaceResImpl) resImpl).isStaticFace(i3);
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
        }
        return false;
    }

    public static boolean isSysFaceUseNtDownload() {
        return FreesiaWrapperImpl.INSTANCE.b().isSwitchOn(SYS_FACE_NT_DOWNLOAD_SWITCH, true);
    }

    public static boolean isValidFaceId(int i3) {
        if (i3 == 255 || i3 == 511 || i3 == 250 || i3 < 0 || i3 > 65535) {
            return false;
        }
        return true;
    }

    public static int maxServerId() {
        QQSysAndEmojiResInfo resImpl = QQSysAndEmojiResMgr.getInstance().getResImpl(1);
        if (resImpl instanceof QQSysFaceResImpl) {
            return ((QQSysFaceResImpl) resImpl).getMaxServerId();
        }
        return 0;
    }

    protected static int parseAnimCountByModel(String str, String str2) {
        try {
            for (String str3 : str.split("\\|")) {
                String[] split = str3.split(":");
                if (split.length == 2 && str2.equalsIgnoreCase(split[0])) {
                    return Integer.parseInt(split[1]);
                }
            }
            return -1;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "parseAnimCountByModel error!", e16);
            return -1;
        }
    }

    protected static int parseAnimCountByVersion(String str, int i3) {
        try {
            for (String str2 : str.split("\\|")) {
                String[] split = str2.split(":");
                if (split.length == 2) {
                    String[] split2 = split[0].split("-");
                    if ((TextUtils.isEmpty(split2[0]) || i3 >= Integer.parseInt(split2[0])) && (split2.length <= 1 || TextUtils.isEmpty(split2[1]) || i3 < Integer.parseInt(split2[1]))) {
                        return Integer.parseInt(split[1]);
                    }
                }
            }
            return 10;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "parseAnimCountByVersion error!", e16);
            return 10;
        }
    }

    public static void preLoadEmoDrawable() {
        QQSysAndEmojiResMgr.getInstance().getResImpl(1).preLoadURLDrawable();
    }

    public static Map<Integer, QQSysAndEmojiResInfo.QQEmoConfigItem> sysConfigItemMap() {
        ConcurrentHashMap<Integer, QQSysAndEmojiResInfo.QQEmoConfigItem> concurrentHashMap = QQSysAndEmojiResMgr.getInstance().getResImpl(1).mConfigItemMap;
        if (concurrentHashMap == null) {
            return Collections.emptyMap();
        }
        return Collections.unmodifiableMap(concurrentHashMap);
    }

    public static void updateAnimEmoCount() {
        oa1.d c16 = ba.INSTANCE.c();
        if (c16 != null) {
            if (!TextUtils.isEmpty(c16.f422307n.f422274a)) {
                sAnimEmoCountFlag = true;
                sAnimEmoCount = parseAnimCountByModel(c16.f422307n.f422274a, DeviceInfoMonitor.getModel());
            }
            if (!sAnimEmoCountFlag && !TextUtils.isEmpty(c16.f422307n.f422275b)) {
                sAnimEmoCountFlag = true;
                sAnimEmoCount = parseAnimCountByVersion(c16.f422307n.f422275b, Build.VERSION.SDK_INT);
            }
        }
        QLog.d(TAG, 1, "updateAnimEmoCount animCount:", Integer.valueOf(sAnimEmoCount));
    }

    @Nullable
    public static AniStickerInfo getAniStickerInfo(int i3, String str, String str2) {
        return ((QQSysFaceResImpl) QQSysAndEmojiResMgr.getInstance().getResImpl(1)).getAniStickerInfo(i3, str, str2);
    }

    public static String getEMCode(String str) {
        QQSysAndEmojiResInfo resImpl = QQSysAndEmojiResMgr.getInstance().getResImpl(1);
        if (resImpl instanceof QQSysFaceResImpl) {
            return ((QQSysFaceResImpl) resImpl).getEMCode(str);
        }
        return null;
    }
}
