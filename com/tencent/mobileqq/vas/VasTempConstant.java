package com.tencent.mobileqq.vas;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VasTempConstant {
    public static final String APP_ROOT;
    public static final String CARD_DOWN_LOAD_DIR;
    public static final String ENGINE_CONFIG_PATH;
    private static final String EXTERNAL_ROOT_DIR;
    public static final String GUILD_DOWN_LOAD_DIR;
    private static final String INTERNAL_ROOT_DIR;
    public static final String INTERNAL_VAS_MATERIAL_FOLDER_DIR;
    private static final String TAG = "VasTempConstant";
    private static final boolean dirMoveEnable = VasNtToggle.INSTANCE.getVAS_SDCARD_DIR_MOVE().isEnable(true);

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class External {
        public static final String DYNAMIC_DRAWABLE_DIR = VasTempConstant.getExternalDir("dynamic_drawable");
        public static final String BEANCURD_DRESS_DIR = VasTempConstant.getExternalDir("beancurd_dress_show");
        public static final String KUIKLY_DOWNLOAD_DIR = VasTempConstant.getExternalDir("kuikly_download");
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class Internal {
        public static final String DEBUG_DIR = VasTempConstant.getInternalDir("debug");
    }

    static {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(BaseApplication.getContext().getFilesDir().getAbsolutePath());
        String str = File.separator;
        sb5.append(str);
        sb5.append("qqvip");
        sb5.append(str);
        String sb6 = sb5.toString();
        INTERNAL_ROOT_DIR = sb6;
        ENGINE_CONFIG_PATH = BaseApplication.getContext().getFilesDir().getAbsolutePath() + str + "quickupdate";
        StringBuilder sb7 = new StringBuilder();
        sb7.append(BaseApplication.getContext().getFilesDir().getAbsolutePath());
        sb7.append(str);
        String sb8 = sb7.toString();
        APP_ROOT = sb8;
        INTERNAL_VAS_MATERIAL_FOLDER_DIR = sb8 + "files" + str + "vas_material_folder/";
        StringBuilder sb9 = new StringBuilder();
        String str2 = AppConstants.SDCARD_PATH;
        sb9.append(str2);
        sb9.append(str);
        sb9.append(AppConstants.PATH_GUILD);
        GUILD_DOWN_LOAD_DIR = getVasPrivatePath(sb9.toString());
        CARD_DOWN_LOAD_DIR = getVasPrivatePath(str2 + str + ".card/");
        File externalFilesDir = BaseApplication.getContext().getExternalFilesDir("qqvip");
        if (externalFilesDir != null) {
            EXTERNAL_ROOT_DIR = externalFilesDir.getAbsolutePath() + str;
            return;
        }
        EXTERNAL_ROOT_DIR = sb6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getExternalDir(String str) {
        return EXTERNAL_ROOT_DIR + str + File.separator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getInternalDir(String str) {
        return INTERNAL_ROOT_DIR + str + File.separator;
    }

    @SuppressLint({"SdCardPath"})
    private static String getInternalFilesDir(String str) {
        String str2;
        String str3;
        if (dirMoveEnable) {
            String decodeString = VasNtMMKV.getFileDir().decodeString(str, "");
            if (!TextUtils.isEmpty(decodeString)) {
                return decodeString;
            }
            try {
                str3 = AppConstants.SDCARD_PATH;
            } catch (Exception e16) {
                e = e16;
                str2 = str;
            }
            if (str.startsWith(str3)) {
                String[] split = str.split(str3);
                if (split.length > 1) {
                    str2 = INTERNAL_ROOT_DIR + split[1];
                } else {
                    str2 = INTERNAL_ROOT_DIR;
                }
                try {
                    if (str2.startsWith("/data/data/com.qingot.realtime/virtual")) {
                        str2 = str2.replace("/data/data/com.qingot.realtime/virtual", "");
                    }
                    VasNtMMKV.getFileDir().encodeString(str, str2);
                } catch (Exception e17) {
                    e = e17;
                    QLog.e(TAG, 1, e, new Object[0]);
                    VasNtCommonReporter.getPrivatePath().setValue1(str).setValue2(str2).report();
                    return str2;
                }
                VasNtCommonReporter.getPrivatePath().setValue1(str).setValue2(str2).report();
                return str2;
            }
        }
        str2 = str;
        VasNtCommonReporter.getPrivatePath().setValue1(str).setValue2(str2).report();
        return str2;
    }

    public static String getVasPrivatePath(String str) {
        if ((TextUtils.isEmpty(str) || !str.startsWith(AppConstants.SDCARD_PATH)) && dirMoveEnable) {
            return str;
        }
        String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(str);
        if (TextUtils.equals(sDKPrivatePath, str)) {
            return getInternalFilesDir(str);
        }
        return sDKPrivatePath;
    }
}
