package com.tencent.mobileqq.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.VipMMKV;
import com.tencent.mobileqq.vas.profilecard.util.LevelUtil;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.stat.MttLoader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes20.dex */
public class ProfileCardTemplateUtil {

    /* renamed from: a, reason: collision with root package name */
    public static ArrayList<ProfileCardTemplate> f306407a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    public static String f306408b = "";

    public static void a(final QQAppInterface qQAppInterface) {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.util.ProfileCardTemplateUtil.2
            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                QQAppInterface qQAppInterface2 = QQAppInterface.this;
                if (qQAppInterface2 != null) {
                    SharedPreferences preferences = qQAppInterface2.getPreferences();
                    String string = preferences.getString("cardTemplateVersion", "0");
                    String string2 = preferences.getString("cardTemplateServerVersion", "0");
                    String string3 = preferences.getString("cardTemplateServerUrl", "0");
                    if (QLog.isColorLevel()) {
                        QLog.d("ProfileCardUtil", 2, "func downloadProfileStyleFile, serverUrl:" + string3 + ",localVersion:" + string + ",serverVersion:" + string2);
                    }
                    if (!TextUtils.equals(string, string2) && !TextUtils.isEmpty(string3)) {
                        if (QLog.isColorLevel()) {
                            QLog.d("ProfileCardUtil", 2, "downloadProfileStyleFile start downloadProfileStyleFile url=" + string3 + MttLoader.QQBROWSER_PARAMS_VERSION + string2);
                        }
                        try {
                            String h16 = ProfileCardTemplateUtil.h(QQAppInterface.this.getApplication());
                            File file = new File(h16 + ".tmp");
                            com.tencent.mobileqq.vip.g gVar = new com.tencent.mobileqq.vip.g(string3, file);
                            gVar.S = "profileCardDownload";
                            gVar.R = "VIP_profilecard";
                            gVar.V = (byte) 1;
                            int o16 = DownloaderFactory.o(gVar, QQAppInterface.this);
                            if (o16 == 0) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("ProfileCardUtil", 2, "func downloadProfileStyleFile, downloadSuccess:" + z16);
                            }
                            if (z16) {
                                if (file.exists()) {
                                    String readFileContent = FileUtils.readFileContent(file);
                                    if (!TextUtils.isEmpty(readFileContent) && new JSONObject(readFileContent).optJSONArray("style").length() > 0) {
                                        FileUtils.copyFile(h16 + ".tmp", h16);
                                        file.delete();
                                        File[] listFiles = new File(h16).getParentFile().listFiles();
                                        if (listFiles != null && listFiles.length > 0) {
                                            for (File file2 : listFiles) {
                                                String name = file2.getName();
                                                if (name.startsWith(ProfileCardTemplate.QVIP_PROFILE_TEMPLATE_JSON) && !name.endsWith(AppSetting.f99551k)) {
                                                    FileUtils.deleteFile(name);
                                                    if (QLog.isColorLevel()) {
                                                        QLog.i(LevelUtil.PROFILE_CARD_TAG, 2, "delete old file=" + name);
                                                    }
                                                }
                                            }
                                        }
                                        preferences.edit().putString("cardTemplateVersion", string2).commit();
                                        ProfileCardTemplateUtil.k(true);
                                        if (QLog.isColorLevel()) {
                                            QLog.d(LevelUtil.PROFILE_CARD_TAG, 2, "ProfileCardCheckUpdate update template list file success version=" + string2);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d(LevelUtil.PROFILE_CARD_TAG, 2, "ProfileCardCheckUpdate download error resultCode=" + o16 + JefsClass.INDEX_URL + string3);
                            }
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                        }
                    }
                }
            }
        }, 5, null, false);
    }

    public static void b(final QQAppInterface qQAppInterface) {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.util.ProfileCardTemplateUtil.1
            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                if (QQAppInterface.this != null) {
                    String decodeString = VipMMKV.getCommon().decodeString("profile_card_template_config_url", "");
                    String stringData = VasToggle.FEATURE_PROFILE_CARD_TEMPLATE_CONFIG.getStringData("https://tianquan.gtimg.cn/shoal/qqgxh/summary-card-diy-preview-json-1720581446.json");
                    QLog.d("ProfileCardUtil", 2, "func downloadProfileStyleFile, serverUrl:" + stringData);
                    if (!TextUtils.equals(decodeString, stringData)) {
                        if (QLog.isColorLevel()) {
                            QLog.d("ProfileCardUtil", 2, "downloadProfileStyleFile start downloadProfileStyleFile url=" + stringData);
                        }
                        try {
                            String h16 = ProfileCardTemplateUtil.h(QQAppInterface.this.getApplication());
                            File file = new File(h16 + ".tmp");
                            com.tencent.mobileqq.vip.g gVar = new com.tencent.mobileqq.vip.g(stringData, file);
                            gVar.S = "profileCardDownload";
                            gVar.R = "VIP_profilecard";
                            gVar.V = (byte) 1;
                            int o16 = DownloaderFactory.o(gVar, QQAppInterface.this);
                            if (o16 == 0) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("ProfileCardUtil", 2, "func downloadProfileStyleFile, downloadSuccess:" + z16);
                            }
                            if (z16) {
                                if (file.exists()) {
                                    String readFileContent = FileUtils.readFileContent(file);
                                    if (!TextUtils.isEmpty(readFileContent) && new JSONObject(readFileContent).optJSONArray("style").length() > 0) {
                                        FileUtils.copyFile(h16 + ".tmp", h16);
                                        file.delete();
                                        File[] listFiles = new File(h16).getParentFile().listFiles();
                                        if (listFiles != null && listFiles.length > 0) {
                                            for (File file2 : listFiles) {
                                                String name = file2.getName();
                                                if (name.startsWith(ProfileCardTemplate.QVIP_PROFILE_TEMPLATE_JSON) && !name.endsWith(AppSetting.f99551k)) {
                                                    FileUtils.deleteFile(name);
                                                    if (QLog.isColorLevel()) {
                                                        QLog.i(LevelUtil.PROFILE_CARD_TAG, 2, "delete old file=" + name);
                                                    }
                                                }
                                            }
                                        }
                                        VipMMKV.getCommon().encodeString("profile_card_template_config_url", stringData);
                                        ProfileCardTemplateUtil.k(true);
                                        if (QLog.isColorLevel()) {
                                            QLog.d(LevelUtil.PROFILE_CARD_TAG, 2, "ProfileCardCheckUpdate update template list file success");
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d(LevelUtil.PROFILE_CARD_TAG, 2, "ProfileCardCheckUpdate download error resultCode=" + o16 + JefsClass.INDEX_URL + stringData);
                            }
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                        }
                    }
                }
            }
        }, 5, null, false);
    }

    private static boolean c(ProfileCardTemplate profileCardTemplate) {
        int i3;
        long serverTime = NetConnInfoCenter.getServerTime();
        int i16 = profileCardTemplate.templateBeginTime;
        if ((i16 > 100 && serverTime < i16) || ((i3 = profileCardTemplate.templateEndTime) > 100 && serverTime > i3)) {
            if (QLog.isColorLevel()) {
                QLog.w("ProfileCardUtil", 2, "filterTemplate->sytle:" + profileCardTemplate.styleId + ",beginTime:" + profileCardTemplate.templateBeginTime + ",endTime:" + profileCardTemplate.templateEndTime);
                return false;
            }
            return false;
        }
        return true;
    }

    public static String d() {
        BaseApplication context = BaseApplication.getContext();
        try {
            if (Utils.B()) {
                return AppConstants.PROFILE_CARD_BACKGROUND_DIR;
            }
            return context.getDir(AppConstants.DEFAULT_PROFILE_CARD_DIRNAME, 0).getAbsoluteFile() + File.separator;
        } catch (Exception e16) {
            QLog.e(LevelUtil.PROFILE_CARD_TAG, 1, "getBGDir error, e = " + e16);
            return context.getDir(AppConstants.DEFAULT_PROFILE_CARD_DIRNAME, 0).getAbsoluteFile() + File.separator;
        }
    }

    public static String e(long j3) {
        String absolutePath = BaseApplication.getContext().getDir(AppConstants.DEFAULT_PROFILE_CARD_DIRNAME, 0).getAbsolutePath();
        if (j3 == -1) {
            return absolutePath + File.separator + "common_" + ProfileCardTemplate.PROFILE_COMMON_VERSION;
        }
        if (j3 != ProfileCardTemplate.DEFAULT_PROFILE_CARD_STYLE_ID && j3 > 0) {
            return absolutePath + File.separator + j3;
        }
        return null;
    }

    public static String f(Context context) {
        return context.getDir(AppConstants.DEFAULT_PROFILE_CARD_DIRNAME, 0).getAbsolutePath() + File.separator + "qvip_profile_label_config.json" + AppSetting.f99551k;
    }

    public static ArrayList<ProfileCardTemplate> g(boolean z16, boolean z17) {
        if (QLog.isColorLevel()) {
            QLog.d(LevelUtil.PROFILE_CARD_TAG, 2, "getProfileTemplateList isReturnHidden=" + z16 + ",returnExpire=" + z17);
        }
        ArrayList<ProfileCardTemplate> arrayList = new ArrayList<>();
        ArrayList<ProfileCardTemplate> k3 = k(false);
        if (!k3.isEmpty()) {
            Iterator<ProfileCardTemplate> it = k3.iterator();
            while (it.hasNext()) {
                ProfileCardTemplate next = it.next();
                if (z16 || !next.isHide) {
                    if (z17) {
                        arrayList.add(next);
                    } else if (c(next)) {
                        arrayList.add(next);
                    }
                }
            }
        }
        return arrayList;
    }

    public static String h(Context context) {
        return context.getDir(AppConstants.DEFAULT_PROFILE_CARD_DIRNAME, 0).getAbsolutePath() + File.separator + ProfileCardTemplate.QVIP_PROFILE_TEMPLATE_JSON + AppSetting.f99551k;
    }

    public static ProfileCardTemplate i(long j3, boolean z16) {
        if (j3 == ProfileCardTemplate.DEFAULT_PROFILE_CARD_STYLE_ID) {
            return null;
        }
        boolean z17 = true;
        ArrayList<ProfileCardTemplate> g16 = g(true, z16);
        int size = g16.size();
        ProfileCardTemplate profileCardTemplate = null;
        int i3 = 0;
        while (true) {
            if (i3 < size) {
                profileCardTemplate = g16.get(i3);
                if (profileCardTemplate != null && profileCardTemplate.styleId == j3) {
                    break;
                }
                i3++;
            } else {
                z17 = false;
                break;
            }
        }
        if (!z17) {
            return null;
        }
        return profileCardTemplate;
    }

    public static boolean j() {
        String e16 = e(-1L);
        boolean z16 = false;
        if (e16 != null) {
            File file = new File(e16);
            File file2 = new File(e16 + File.separator + "config_black.json");
            if (file.isDirectory() && file2.exists()) {
                z16 = true;
            }
            if (QLog.isColorLevel()) {
                QLog.d(LevelUtil.PROFILE_CARD_TAG, 2, "isExistsTemplateDir common dir exists=" + file.isDirectory() + " templateConfig exists= " + file2.exists());
            }
            return z16;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LevelUtil.PROFILE_CARD_TAG, 2, "isExistsTemplateDir common path is null");
        }
        return false;
    }

    public static ArrayList<ProfileCardTemplate> k(boolean z16) {
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream open;
        if (QLog.isColorLevel()) {
            QLog.d(LevelUtil.PROFILE_CARD_TAG, 2, "loadProfileCardTemplateList");
        }
        BaseApplication context = BaseApplication.getContext();
        String h16 = h(context);
        File file = new File(h16);
        boolean exists = file.exists();
        if (!exists) {
            h16 = "assets/qvip_profile_template.json";
        }
        if (TextUtils.equals(f306408b, h16) && !f306407a.isEmpty() && !z16) {
            return f306407a;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LevelUtil.PROFILE_CARD_TAG, 2, "loadProfileCardTemplateList from file");
        }
        ArrayList<ProfileCardTemplate> arrayList = new ArrayList<>();
        InputStream inputStream = null;
        try {
            try {
                if (exists) {
                    open = new FileInputStream(file);
                } else {
                    open = context.getAssets().open(ProfileCardTemplate.QVIP_PROFILE_TEMPLATE_JSON);
                }
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (Throwable th5) {
                    th = th5;
                    byteArrayOutputStream = null;
                }
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        } catch (Throwable th6) {
            th = th6;
            byteArrayOutputStream = null;
        }
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = open.read(bArr, 0, 4096);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            String str = new String(byteArrayOutputStream.toByteArray(), "utf-8");
            if (str.length() > 0) {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("style")) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("style");
                    int length = optJSONArray.length();
                    int i3 = 0;
                    while (true) {
                        boolean z17 = true;
                        if (i3 >= length) {
                            break;
                        }
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                        ProfileCardTemplate profileCardTemplate = new ProfileCardTemplate();
                        profileCardTemplate.styleId = jSONObject2.optInt("id");
                        profileCardTemplate.name = jSONObject2.optString("name");
                        profileCardTemplate.version = jSONObject2.optString("version");
                        profileCardTemplate.auth = jSONObject2.optString(WinkDaTongReportConstant.ElementParamValue.XSJ_OPERATION_TYPE_AUTH);
                        profileCardTemplate.tag = jSONObject2.optInt("tag");
                        profileCardTemplate.tagBeginTime = jSONObject2.optInt("tag_btime");
                        profileCardTemplate.tagEndTime = jSONObject2.optInt("tag_etime");
                        profileCardTemplate.imageBlack = jSONObject2.optString("image_black");
                        profileCardTemplate.imageBlackMin = jSONObject2.optString("image_blackmin");
                        profileCardTemplate.imageBlackMax = jSONObject2.optString("image_blackmax");
                        profileCardTemplate.imageBlackSmall = jSONObject2.optString("image_blacksmall");
                        profileCardTemplate.imageWhite = jSONObject2.optString("image_white");
                        profileCardTemplate.imageWhiteMin = jSONObject2.optString("image_whitemin");
                        profileCardTemplate.imageWhiteMax = jSONObject2.optString("image_whitemax");
                        profileCardTemplate.imageWhiteSmall = jSONObject2.optString("image_whitesmall");
                        profileCardTemplate.animation = jSONObject2.optInt("animation");
                        profileCardTemplate.frameBlack = jSONObject2.optString("frame_black");
                        profileCardTemplate.frameBlackMin = jSONObject2.optString("frame_blackmin");
                        profileCardTemplate.frameBlackMax = jSONObject2.optString("frame_blackmax");
                        profileCardTemplate.frameBlackSmall = jSONObject2.optString("frame_blacksmall");
                        profileCardTemplate.frameWhite = jSONObject2.optString("frame_white");
                        profileCardTemplate.frameWhiteMax = jSONObject2.optString("frame_whitemax");
                        profileCardTemplate.frameWhiteMin = jSONObject2.optString("frame_whitemin");
                        profileCardTemplate.frameWhiteSmall = jSONObject2.optString("frame_whitesmall");
                        profileCardTemplate.imageSize = jSONObject2.optInt("imageSize");
                        profileCardTemplate.downloadUrl = jSONObject2.optString("AndDownloadUrl");
                        profileCardTemplate.size = jSONObject2.optInt("AndSize");
                        profileCardTemplate.templateBeginTime = jSONObject2.optInt("template_btime");
                        profileCardTemplate.templateEndTime = jSONObject2.optInt("template_etime");
                        profileCardTemplate.limitefreeType = jSONObject2.optInt("limitefree_type");
                        profileCardTemplate.limitefreeBtime = jSONObject2.optInt("limitefree_btime");
                        profileCardTemplate.limitefreeEtime = jSONObject2.optInt("limitefree_etime");
                        int optInt = jSONObject2.optInt("hide");
                        profileCardTemplate.customBackgroundAuth = jSONObject2.optInt("custom_auth");
                        if (optInt != 1) {
                            z17 = false;
                        }
                        profileCardTemplate.isHide = z17;
                        arrayList.add(profileCardTemplate);
                        i3++;
                    }
                    ProfileCardTemplate profileCardTemplate2 = new ProfileCardTemplate();
                    profileCardTemplate2.styleId = 11L;
                    profileCardTemplate2.isHide = true;
                    arrayList.add(profileCardTemplate2);
                    ProfileCardTemplate profileCardTemplate3 = new ProfileCardTemplate();
                    profileCardTemplate3.styleId = 10L;
                    profileCardTemplate3.isHide = true;
                    arrayList.add(profileCardTemplate3);
                    ProfileCardTemplate profileCardTemplate4 = new ProfileCardTemplate();
                    profileCardTemplate4.styleId = 21L;
                    profileCardTemplate4.isHide = true;
                    arrayList.add(profileCardTemplate4);
                    ProfileCardTemplate profileCardTemplate5 = new ProfileCardTemplate();
                    profileCardTemplate5.styleId = ProfileCardTemplate.PROFILE_CARD_STYLE_VAS_CUSTOM_BG_TEMPLATE;
                    profileCardTemplate5.isHide = VasToggle.BUG_108446460.isEnable(true);
                    arrayList.add(profileCardTemplate5);
                }
            }
            open.close();
            byteArrayOutputStream.close();
        } catch (Throwable th7) {
            th = th7;
            inputStream = open;
            try {
                th.printStackTrace();
                if (inputStream != null) {
                    inputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                f306408b = h16;
                f306407a = arrayList;
                return arrayList;
            } catch (Throwable th8) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e17) {
                        e17.printStackTrace();
                        throw th8;
                    }
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                throw th8;
            }
        }
        f306408b = h16;
        f306407a = arrayList;
        return arrayList;
    }
}
