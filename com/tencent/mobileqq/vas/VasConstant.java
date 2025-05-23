package com.tencent.mobileqq.vas;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.AppOpenConstants;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VasConstant {
    public static final String APP_ROOT;
    public static final String CARD_DOWN_LOAD_DIR;
    public static final String COLOR_SCREEN_DIR;
    public static final String DOWNLOADER_FACTORY_TMP_DIR;
    public static final String FILE_PATH_LOTTIE_DOWNLOAD;
    public static final String FONT_DOWN_LOAD_PATH;
    public static final String FUN_CALL_DOWN_LOAD_DIR;
    public static final String GUILD_DOWN_LOAD_DIR;
    public static final String HI_BOOM_DOWN_LOAD_DIR;
    public static final String INTERNAL_BUBBLE_DIR;
    public static final String INTERNAL_CACHE_DIR;
    public static final String INTERNAL_CUSTOM_BG_DIR;
    public static final String INTERNAL_DIY_BUBBLE_DIR;
    public static final String INTERNAL_FILES_DIR;
    public static final String INTERNAL_GLDRAWABLE_ETC_DIR;
    public static final String INTERNAL_LOTTIE_CACHE_DIR;
    public static final String INTERNAL_QZONE_CACHE_DIR;
    public static final String INTERNAL_QZONE_RES_DIR;
    public static final String INTERNAL_QZONE_RES_ZIP_DIR;
    public static final String INTERNAL_VAS_FILES_DIR;
    public static final String INTERNAL_VAS_SO_DIR;
    public static final String LOTTIE_DOWN_LOAD_DIR;
    public static final String NEW_CARD_DOWN_LOAD_DIR;
    public static final String PENDANT_DOWN_LOAD_DIR;
    public static final String PRO_FILE_CARD_DOWN_LOAD_DIR;
    public static final String QZONE_ALBUM_THEME_DOWN_LOAD_DIR;
    public static final String QZONE_BUBBLE_DOWN_LOAD_DIR;
    public static final String QZONE_CACHE_DOWN_LOAD_DIR;
    public static final String QZONE_DIY_DOWN_LOAD_DIR;
    public static final String QZONE_DOWN_LOAD_DIR;
    public static final String QZONE_FACADE_DOWN_LOAD_DIR;
    public static final String QZONE_FONT_DOWN_LOAD_DIR;
    public static final String QZONE_IMAGEV2_DOWN_LOAD_DIR;
    public static final String[] RES_FILES;
    public static final String SDCARD_ROOT;
    public static final String SIGNATURE_STICKER_DIR;
    public static final String SIGNATURE_TEMPLATE_DIR;
    public static final String SP_KING_CARD = "qq_vas_kingcard";
    public static final String SP_TIANSHU = "tianshu_manager";
    private static final String TAG = "VasConstant";
    public static final String URL_DRAWABLE_DOWN_LOAD_DIR;
    public static final String VAS_ROOT;
    public static final String WEBSO_DATA_PATH;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class AppId {
        public static final int BUBBLE = 2;
        public static final int CARD = 15;
        public static final int CHATBG = 8;
        public static final int EMOJI = 1;
        public static final int FACE = 23;
        public static final int FLASHSCREEN = 22;
        public static final int FONT = 5;
        public static final int FUNCALL = 17;

        /* renamed from: GROUP, reason: collision with root package name */
        public static final int f307869GROUP = 26;
        public static final int LIKE = 20;
        public static final int NONE = 0;
        public static final int QQRING = 37;
        public static final int REDPACKET = 16;
        public static final int RING = 6;
        public static final int SIGNATURE = 9;
        public static final int THEME = 3;
        public static final int WIDGET = 4;
    }

    static {
        String vasPrivatePath = getVasPrivatePath(AppOpenConstants.SDCARD_ROOT + "/Tencent/MobileQQ/");
        SDCARD_ROOT = vasPrivatePath;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(BaseApplication.getContext().getFilesDir());
        String str = File.separator;
        sb5.append(str);
        String sb6 = sb5.toString();
        APP_ROOT = sb6;
        String str2 = sb6 + "files/";
        INTERNAL_FILES_DIR = str2;
        String str3 = sb6 + "cache/";
        INTERNAL_CACHE_DIR = str3;
        String str4 = vasPrivatePath + "vas/";
        VAS_ROOT = str4;
        String str5 = str4 + "lottie/";
        FILE_PATH_LOTTIE_DOWNLOAD = str5;
        String str6 = vasPrivatePath + "webso/offline/";
        WEBSO_DATA_PATH = str6;
        INTERNAL_VAS_FILES_DIR = str2 + "qqvip/";
        String str7 = str2 + "bubble_info/";
        INTERNAL_BUBBLE_DIR = str7;
        INTERNAL_CUSTOM_BG_DIR = BaseApplication.getContext().getFilesDir() + "/custom_background/";
        String str8 = str2 + "bubble_paster/";
        INTERNAL_DIY_BUBBLE_DIR = str8;
        String str9 = str2 + "vas_so/";
        INTERNAL_VAS_SO_DIR = str9;
        String str10 = str2 + "qzoneres/";
        INTERNAL_QZONE_RES_DIR = str10;
        String str11 = str2 + "qzonereszip/";
        INTERNAL_QZONE_RES_ZIP_DIR = str11;
        String str12 = str2 + "cache/";
        INTERNAL_QZONE_CACHE_DIR = str12;
        String str13 = str2 + "gldrawable/autoetc/";
        INTERNAL_GLDRAWABLE_ETC_DIR = str13;
        String str14 = str3 + "lottie_network_cache/";
        INTERNAL_LOTTIE_CACHE_DIR = str14;
        StringBuilder sb7 = new StringBuilder();
        String str15 = AppConstants.SDCARD_PATH;
        sb7.append(str15);
        sb7.append(".font_info/");
        String vasPrivatePath2 = getVasPrivatePath(sb7.toString());
        FONT_DOWN_LOAD_PATH = vasPrivatePath2;
        String vasPrivatePath3 = getVasPrivatePath(str15 + ".hiboom_font/");
        HI_BOOM_DOWN_LOAD_DIR = vasPrivatePath3;
        String vasPrivatePath4 = getVasPrivatePath(str15 + ".pendant/");
        PENDANT_DOWN_LOAD_DIR = vasPrivatePath4;
        GUILD_DOWN_LOAD_DIR = getVasPrivatePath(str15 + AppConstants.PATH_GUILD);
        String vasPrivatePath5 = getVasPrivatePath(str15 + ".profilecard/");
        PRO_FILE_CARD_DOWN_LOAD_DIR = vasPrivatePath5;
        String vasPrivatePath6 = getVasPrivatePath(str15 + ".card/");
        CARD_DOWN_LOAD_DIR = vasPrivatePath6;
        NEW_CARD_DOWN_LOAD_DIR = getVasPrivatePath(str15 + "newCard/");
        String vasPrivatePath7 = getVasPrivatePath(str15 + ".funcall/");
        FUN_CALL_DOWN_LOAD_DIR = vasPrivatePath7;
        String vasPrivatePath8 = getVasPrivatePath(str15 + ".vipicon/");
        URL_DRAWABLE_DOWN_LOAD_DIR = vasPrivatePath8;
        String vasPrivatePath9 = getVasPrivatePath(str15 + ".apollo/image_cache/");
        LOTTIE_DOWN_LOAD_DIR = vasPrivatePath9;
        String vasPrivatePath10 = getVasPrivatePath(str15 + "qzone/");
        QZONE_DOWN_LOAD_DIR = vasPrivatePath10;
        String str16 = vasPrivatePath10 + "zip_cache/";
        QZONE_CACHE_DOWN_LOAD_DIR = str16;
        String str17 = vasPrivatePath10 + "personalise_font/";
        QZONE_FONT_DOWN_LOAD_DIR = str17;
        String str18 = vasPrivatePath10 + "passive_praise/";
        QZONE_BUBBLE_DOWN_LOAD_DIR = str18;
        String str19 = vasPrivatePath10 + "facade/";
        QZONE_FACADE_DOWN_LOAD_DIR = str19;
        String str20 = vasPrivatePath10 + "AlbumTheme/";
        QZONE_ALBUM_THEME_DOWN_LOAD_DIR = str20;
        String str21 = vasPrivatePath10 + "diy/";
        QZONE_DIY_DOWN_LOAD_DIR = str21;
        String str22 = vasPrivatePath10 + "imageV2/";
        QZONE_IMAGEV2_DOWN_LOAD_DIR = str22;
        String str23 = AppConstants.SDCARD_SIGNATURE_TEMPLATE_ROOT;
        SIGNATURE_TEMPLATE_DIR = str23;
        SIGNATURE_STICKER_DIR = str23 + "stickers/";
        String str24 = BaseApplication.getContext().getCacheDir() + str + ".download_factory_tmp";
        DOWNLOADER_FACTORY_TMP_DIR = str24;
        String str25 = sb6 + "color_screen/";
        COLOR_SCREEN_DIR = str25;
        RES_FILES = new String[]{str5, str6, str7, str9, str10, str11, vasPrivatePath2, vasPrivatePath3, vasPrivatePath4, vasPrivatePath5, vasPrivatePath6, vasPrivatePath7, vasPrivatePath8, vasPrivatePath9, str12, str16, str17, str18, str19, str20, str21, str22, str8, str25, str23, str13, str14, str24};
    }

    @SuppressLint({"SdCardPath"})
    private static String getInternalFilesDir(String str) {
        String str2;
        String decodeString = VasMMKV.getFileDir().decodeString(str, "");
        if (!TextUtils.isEmpty(decodeString)) {
            return decodeString;
        }
        try {
            String str3 = AppConstants.SDCARD_PATH;
            if (str.startsWith(str3)) {
                String[] split = str.split(str3);
                if (split.length > 1) {
                    str2 = INTERNAL_VAS_FILES_DIR + split[1];
                } else {
                    str2 = INTERNAL_VAS_FILES_DIR;
                }
                try {
                    if (str2.startsWith("/data/data/com.qingot.realtime/virtual")) {
                        str2 = str2.replace("/data/data/com.qingot.realtime/virtual", "");
                    }
                    VasMMKV.getFileDir().encodeString(str, str2);
                    return str2;
                } catch (Exception e16) {
                    e = e16;
                    str = str2;
                    QLog.e(TAG, 1, e, new Object[0]);
                    return str;
                }
            }
            return str;
        } catch (Exception e17) {
            e = e17;
        }
    }

    private static String getVasPrivatePath(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith(AppConstants.SDCARD_PATH)) {
            String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(str);
            if (TextUtils.equals(sDKPrivatePath, str)) {
                return getInternalFilesDir(str);
            }
            return sDKPrivatePath;
        }
        return str;
    }
}
