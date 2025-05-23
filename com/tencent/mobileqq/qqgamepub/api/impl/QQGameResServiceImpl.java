package com.tencent.mobileqq.qqgamepub.api.impl;

import android.content.SharedPreferences;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.commonsdk.util.MD5Coding;
import com.tencent.mobileqq.ark.api.IArkHelper;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqgamepub.api.IQQGamePreDownloadService;
import com.tencent.mobileqq.qqgamepub.api.IQQGameResService;
import com.tencent.mobileqq.qqgamepub.data.QQGameResInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadScheduleUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import cooperation.photoplus.sticker.Sticker;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QQGameResServiceImpl implements IQQGameResService {
    static IPatchRedirector $redirector_ = null;
    private static final String KEY_ARK_RES_FILE_NAME = "url_res_file_name";
    private static final String KEY_CHECK_SURPLUS_RES_LAST_TIME = "check_surplus_res_time";
    private static final String KEY_RES_URL_DONETIME = "url_doneTime";
    private static final String KEY_RES_URL_LAST_USE_TIME = "url_last_use_time";
    private static final String KEY_RES_URL_MD5 = "url_md5";
    private static final long SIZE_TO_REMOVE_SURPLUS_RES = 104857600;
    public static final String SP_QQ_GAME_RES_PRELOAD = "sp_qq_game_res_preload";
    private static final String TAG = "QQGamePub_QQGameResApiImpl";
    private static final long TIME_INTERVAL_TO_REMOVE_SURPLUS_RES = 1296000000;
    private static final long TIME_INTERVAL_VALID_TO_CHECK = 86400000;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f264439a;

        /* renamed from: b, reason: collision with root package name */
        public long f264440b;

        /* renamed from: c, reason: collision with root package name */
        public int f264441c;

        public a(String str, long j3, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Long.valueOf(j3), Integer.valueOf(i3));
                return;
            }
            this.f264439a = str;
            this.f264440b = j3;
            this.f264441c = i3;
        }
    }

    public QQGameResServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static long getLastCheckSurplusTime(int i3) {
        return getPreference(i3).getLong(KEY_CHECK_SURPLUS_RES_LAST_TIME, 0L);
    }

    public static long getLastUseTime(String str, long j3, int i3) {
        if (!TextUtils.isEmpty(str)) {
            return getPreference(i3).getLong(KEY_RES_URL_LAST_USE_TIME + str, j3);
        }
        return j3;
    }

    public static SharedPreferences getPreference(int i3) {
        if (i3 == 1) {
            return BaseApplication.getContext().getSharedPreferences("sp_qq_game_res_preloadinner", 4);
        }
        return BaseApplication.getContext().getSharedPreferences(SP_QQ_GAME_RES_PRELOAD, 4);
    }

    public static List<a> getResTimeInfoList(int i3) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, ?> entry : getPreference(i3).getAll().entrySet()) {
            String key = entry.getKey();
            if (key.startsWith(KEY_RES_URL_LAST_USE_TIME)) {
                arrayList.add(new a(key.substring(17, key.length()), ((Long) entry.getValue()).longValue(), i3));
            }
        }
        return arrayList;
    }

    public static void updateCheckSurplusTime(long j3, int i3) {
        getPreference(i3).edit().putLong(KEY_CHECK_SURPLUS_RES_LAST_TIME, j3).apply();
    }

    public static void updateLastUseTime(String str, int i3, long j3) {
        if (!TextUtils.isEmpty(str)) {
            getPreference(i3).edit().putLong(KEY_RES_URL_LAST_USE_TIME + str, j3).apply();
        }
    }

    public static void updateUrlMd5(String str, String str2, int i3) {
        SharedPreferences preference = getPreference(i3);
        if (preference != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            preference.edit().putString(KEY_RES_URL_MD5 + str, str2).apply();
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameResService
    public void checkAndCleanExpireCache(int i3) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
            return;
        }
        try {
            com.tencent.mobileqq.qqgamepub.config.c config = ((IQQGamePreDownloadService) QRoute.api(IQQGamePreDownloadService.class)).getConfig();
            long j16 = config.mCheckIntervalTime;
            if (j16 < 0) {
                j16 = 86400000;
            }
            long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
            if (serverTimeMillis - getLastCheckSurplusTime(i3) < j16) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "removeSurplusRes already Check \uff0ccheckIntervalTime\uff1a" + j16);
                    return;
                }
                return;
            }
            long fileOrFolderSize = FileUtils.getFileOrFolderSize(getResPathPrefix(i3));
            long j17 = config.mCleanResFolderMaxSize;
            if (j17 < 0) {
                j17 = 104857600;
            }
            long j18 = config.mCleanIntervalTime;
            if (j18 < 0) {
                j18 = TIME_INTERVAL_TO_REMOVE_SURPLUS_RES;
            }
            if (fileOrFolderSize > j17) {
                for (a aVar : getResTimeInfoList(i3)) {
                    if (aVar != null) {
                        String str = aVar.f264439a;
                        if (!TextUtils.isEmpty(str)) {
                            j3 = j17;
                            if (serverTimeMillis - aVar.f264440b > j18) {
                                QQGameResInfo resInfoByUrl = getResInfoByUrl(str, aVar.f264441c);
                                removeResInfo(str, aVar.f264441c);
                                deleteFile(resInfoByUrl.filePath);
                                deleteFile(resInfoByUrl.folderPath);
                                deleteArkResRecordAndFile(str);
                                if (QLog.isColorLevel()) {
                                    QLog.d(TAG, 2, "checkAndCleanExpireCache: remove res url:" + str + ",filePath:" + resInfoByUrl.filePath);
                                }
                            }
                        } else {
                            j3 = j17;
                        }
                        j17 = j3;
                    }
                }
            }
            long j19 = j17;
            updateCheckSurplusTime(serverTimeMillis, i3);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "checkAndCleanExpireCache:resFolderPathSize:" + fileOrFolderSize + ",cleanResFolderMaxSize:" + j19 + ",cleanIntervalTime:" + j18 + ",cost:" + (NetConnInfoCenter.getServerTimeMillis() - serverTimeMillis));
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameResService
    public void deleteArkResRecordAndFile(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) str);
            return;
        }
        SharedPreferences preference = getPreference(1);
        SharedPreferences.Editor edit = preference.edit();
        Iterator<Map.Entry<String, ?>> it = preference.getAll().entrySet().iterator();
        while (it.hasNext()) {
            String key = it.next().getKey();
            if (key.contains(KEY_ARK_RES_FILE_NAME + str)) {
                deleteFile(getArkResRecordPath(key.replace(KEY_ARK_RES_FILE_NAME + str, ""), str));
                edit.remove(key);
            }
        }
        edit.apply();
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameResService
    public void deleteFile(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
            return;
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                FileUtils.delete(str, false);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "delete file:" + str);
                }
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameResService
    public String getActivityDSL(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, i3);
        }
        String resPathByUrl = getResPathByUrl("https://youxi.gamecenter.qq.com/dsl/" + str + Sticker.JSON_SUFFIX, 0);
        if (!TextUtils.isEmpty(resPathByUrl)) {
            return FileUtils.readFileContent(new File(resPathByUrl));
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "getActivityDSL...activityId:" + str + ",");
            return "";
        }
        return "";
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameResService
    public String getArkResRecordName(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) str2);
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        return getPreference(1).getString(KEY_ARK_RES_FILE_NAME + str2 + str, "");
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameResService
    public String getArkResRecordPath(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2);
        }
        String arkResRecordName = ((IQQGameResService) QRoute.api(IQQGameResService.class)).getArkResRecordName(str, str2);
        if (!TextUtils.isEmpty(arkResRecordName)) {
            return ((IArkHelper) QRoute.api(IArkHelper.class)).getCacheResPath(str, arkResRecordName);
        }
        return "";
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameResService
    public String getFilePath(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, i3);
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return getResPathPrefix(i3) + MD5.toMD5(str);
    }

    public String getRealMd5(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, this, str, str2, Integer.valueOf(i3));
        }
        String resRecordMd5 = getResRecordMd5(str, "", i3);
        if (TextUtils.isEmpty(resRecordMd5) && !TextUtils.isEmpty(str2) && new File(str2).exists()) {
            String encodeFile2HexStr = MD5Coding.encodeFile2HexStr(str2);
            updateUrlMd5(str, encodeFile2HexStr, i3);
            return encodeFile2HexStr;
        }
        return resRecordMd5;
    }

    public QQGameResInfo getResInfoByUrl(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (QQGameResInfo) iPatchRedirector.redirect((short) 18, (Object) this, (Object) str, i3);
        }
        QQGameResInfo qQGameResInfo = new QQGameResInfo();
        qQGameResInfo.url = str;
        String resPathByUrl = getResPathByUrl(str, i3);
        if (!TextUtils.isEmpty(resPathByUrl)) {
            qQGameResInfo.filePath = resPathByUrl;
            qQGameResInfo.fileMd5 = getRealMd5(str, resPathByUrl, i3);
            qQGameResInfo.doneTime = getUrlDoneTime(str, 0L, i3);
        }
        return qQGameResInfo;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameResService
    public String getResPathByUrl(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3);
        }
        if (!TextUtils.isEmpty(str)) {
            String filePath = getFilePath(str, i3);
            if (!TextUtils.isEmpty(filePath) && new File(filePath).exists()) {
                updateLastUseTime(str, i3, NetConnInfoCenter.getServerTimeMillis());
                return filePath;
            }
            return null;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameResService
    public String getResPathPrefix(int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
        StringBuilder sb5 = new StringBuilder();
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(PreDownloadScheduleUtil.getPreDownloadPathStatic(QQGamePreDownloadServiceImpl.QQGAME_PRELOAD_BUSINESSCODE, PreDownloadConstants.DEPARTMENT_SED, z16));
        sb5.append("/");
        return sb5.toString();
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameResService
    public String getResRealMd5(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        }
        return MD5Coding.encodeFile2HexStr(str);
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameResService
    public String getResRecordMd5(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, this, str, str2, Integer.valueOf(i3));
        }
        SharedPreferences preference = getPreference(i3);
        if (preference != null && !TextUtils.isEmpty(str)) {
            return preference.getString(KEY_RES_URL_MD5 + str, str2);
        }
        return str2;
    }

    public long getUrlDoneTime(String str, long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Long) iPatchRedirector.redirect((short) 15, this, str, Long.valueOf(j3), Integer.valueOf(i3))).longValue();
        }
        SharedPreferences preference = getPreference(i3);
        if (preference != null && !TextUtils.isEmpty(str)) {
            return preference.getLong(KEY_RES_URL_DONETIME + str, j3);
        }
        return j3;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameResService
    public boolean isOnlySupportInnerFilePos() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        try {
            z16 = "mounted".equals(Environment.getExternalStorageState());
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
            z16 = false;
        }
        return true ^ z16;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameResService
    public void removeResInfo(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) str, i3);
            return;
        }
        SharedPreferences preference = getPreference(i3);
        if (!TextUtils.isEmpty(str)) {
            SharedPreferences.Editor edit = preference.edit();
            edit.remove(KEY_RES_URL_DONETIME + str);
            edit.remove(KEY_RES_URL_MD5 + str);
            edit.remove(KEY_RES_URL_LAST_USE_TIME + str).apply();
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameResService
    public void saveArkResPreloadName(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, str2, str3);
            return;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            getPreference(1).edit().putString(KEY_ARK_RES_FILE_NAME + str2 + str, str3).apply();
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameResService
    public void updateResInfo(String str, String str2, long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, str, str2, Long.valueOf(j3), Integer.valueOf(i3));
            return;
        }
        updateUrlMd5(str, str2, i3);
        updateUrlDoneTime(str, j3, i3);
        updateLastUseTime(str, i3, NetConnInfoCenter.getServerTimeMillis());
    }

    public void updateUrlDoneTime(String str, long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, str, Long.valueOf(j3), Integer.valueOf(i3));
            return;
        }
        SharedPreferences preference = getPreference(i3);
        if (preference != null && !TextUtils.isEmpty(str)) {
            preference.edit().putLong(KEY_RES_URL_DONETIME + str, j3).apply();
        }
    }
}
