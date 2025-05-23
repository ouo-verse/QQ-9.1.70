package com.tencent.mobileqq.app.utils;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import mqq.app.ISecurityFileHelper;

/* compiled from: P */
/* loaded from: classes11.dex */
public class DiySecureFileHelper {
    static IPatchRedirector $redirector_ = null;
    public static final String FILENAME = "QQ_Favorite";
    public static final String KEY_CHAT_BACKGROUND = "QQThemeChatBackgroundMigration";
    public static final String KEY_QQFAVORITE_DB = "QQFavoriteDBMigration";
    private static final Map<String, Integer> S_VERSION_MAP;
    public static final String TAG = "DiySecureFileHelper";

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private static abstract class BaseFileHelper {
        static IPatchRedirector $redirector_;
        protected final SharedPreferences pref;

        BaseFileHelper() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.pref = BaseApplication.getContext().getSharedPreferences("StepUpdate", 0);
            }
        }

        protected void commitMove() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                this.pref.edit().putBoolean(getKey(), true).commit();
            }
        }

        protected abstract String getKey();

        protected boolean needMoveFile() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return !this.pref.contains(getKey());
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class CustomBackground extends BaseFileHelper implements ISecurityFileHelper {
        static IPatchRedirector $redirector_;

        public CustomBackground() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // mqq.app.ISecurityFileHelper
        public String declareBusinessFileName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return DiySecureFileHelper.FILENAME;
        }

        @Override // mqq.app.ISecurityFileHelper
        public boolean doMigrate(File file) {
            File[] fileArr;
            boolean z16;
            File[] fileArr2;
            File[] fileArr3;
            File[] fileArr4;
            IPatchRedirector iPatchRedirector = $redirector_;
            int i3 = 4;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) file)).booleanValue();
            }
            QLog.d(ISecurityFileHelper.TAG, 1, "Move Theme file start");
            File file2 = new File(DiySecureFileHelper.getSdcardDIYDir());
            if (file2.exists() && file2.isDirectory()) {
                for (File file3 : DiySecureFileHelper.safeListFiles(file2)) {
                    if (file3.isDirectory() && !new File(file3, ".moveflag").exists()) {
                        String name = file3.getName();
                        if (name.length() > 4 && name.matches("[0-9]{5,}")) {
                            String str = file2.getAbsolutePath() + "/" + DiySecureFileHelper.secureUin(name);
                            FileUtils.createFileIfNotExits(str + "/.moveflag");
                            DiySecureFileHelper.rfQuickMove(file3.getAbsolutePath(), str);
                        }
                    }
                }
            }
            File file4 = new File(AppConstants.SDCARD_PATH);
            if (file4.exists() && file4.isDirectory()) {
                File[] safeListFiles = DiySecureFileHelper.safeListFiles(file4);
                int length = safeListFiles.length;
                int i16 = 0;
                while (i16 < length) {
                    File file5 = safeListFiles[i16];
                    String name2 = file5.getName();
                    if (file5.isDirectory() && name2.length() > i3 && name2.matches("[0-9]{5,}")) {
                        if (DiySecureFileHelper.safeListFiles(file5).length > 0) {
                            File[] safeListFiles2 = DiySecureFileHelper.safeListFiles(file5);
                            int length2 = safeListFiles2.length;
                            int i17 = 0;
                            z16 = false;
                            while (i17 < length2) {
                                File file6 = safeListFiles2[i17];
                                if (file6.isDirectory() && file6.getName().equals("custom_background")) {
                                    File[] safeListFiles3 = DiySecureFileHelper.safeListFiles(file6);
                                    int length3 = safeListFiles3.length;
                                    int i18 = 0;
                                    while (i18 < length3) {
                                        File file7 = safeListFiles3[i18];
                                        if (file7.isFile()) {
                                            StringBuilder sb5 = new StringBuilder();
                                            fileArr3 = safeListFiles;
                                            sb5.append(DiySecureFileHelper.getSdcardDIYDir());
                                            sb5.append(DiySecureFileHelper.secureUin(name2));
                                            sb5.append("/.moveflag");
                                            FileUtils.createFileIfNotExits(sb5.toString());
                                            String absolutePath = file7.getAbsolutePath();
                                            StringBuilder sb6 = new StringBuilder();
                                            fileArr4 = safeListFiles3;
                                            sb6.append(DiySecureFileHelper.getSdcardDIYDir());
                                            sb6.append(DiySecureFileHelper.secureUin(name2));
                                            sb6.append("/");
                                            sb6.append(file7.getName());
                                            FileUtils.quickMove(absolutePath, sb6.toString());
                                        } else {
                                            fileArr3 = safeListFiles;
                                            fileArr4 = safeListFiles3;
                                        }
                                        i18++;
                                        safeListFiles = fileArr3;
                                        safeListFiles3 = fileArr4;
                                    }
                                    fileArr2 = safeListFiles;
                                    z16 = true;
                                } else {
                                    fileArr2 = safeListFiles;
                                }
                                i17++;
                                safeListFiles = fileArr2;
                            }
                            fileArr = safeListFiles;
                        } else {
                            fileArr = safeListFiles;
                            z16 = true;
                        }
                    } else {
                        fileArr = safeListFiles;
                        z16 = false;
                    }
                    if (z16) {
                        FileUtils.deleteDirectory(file5.getAbsolutePath());
                    }
                    i16++;
                    safeListFiles = fileArr;
                    i3 = 4;
                }
            }
            commitMove();
            return true;
        }

        @Override // com.tencent.mobileqq.app.utils.DiySecureFileHelper.BaseFileHelper
        protected String getKey() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (String) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return "QQThemeMigration";
        }

        @Override // mqq.app.ISecurityFileHelper
        public boolean needMigration() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return needMoveFile();
        }

        @Override // mqq.app.ISecurityFileHelper
        public File oldBusinessDir(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (File) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            }
            return null;
        }

        @Override // mqq.app.ISecurityFileHelper
        public boolean oldBusinessDirExist(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str)).booleanValue();
            }
            return false;
        }

        @Override // mqq.app.ISecurityFileHelper
        public String[] reportHistoryFileInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String[]) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return new String[]{"0", "0"};
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class QQFavoriteSecurityFileHelper extends BaseFileHelper implements ISecurityFileHelper {
        static IPatchRedirector $redirector_;

        public QQFavoriteSecurityFileHelper() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // mqq.app.ISecurityFileHelper
        public String declareBusinessFileName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return DiySecureFileHelper.FILENAME;
        }

        @Override // mqq.app.ISecurityFileHelper
        public boolean doMigrate(File file) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) file)).booleanValue();
            }
            QLog.d(ISecurityFileHelper.TAG, 1, "Move QQFavorite file start");
            File file2 = new File(AppConstants.SDCARD_IMG_FAVORITE);
            if (file2.exists() && file.isDirectory()) {
                for (File file3 : DiySecureFileHelper.safeListFiles(file2)) {
                    String name = file3.getName();
                    if (name.length() > 4 && name.matches("[0-9]{5}.*")) {
                        FileUtils.quickMove(file3.getAbsolutePath(), AppConstants.SDCARD_IMG_FAVORITE + DiySecureFileHelper.secureUin(name));
                    }
                }
            }
            commitMove();
            return true;
        }

        @Override // com.tencent.mobileqq.app.utils.DiySecureFileHelper.BaseFileHelper
        protected String getKey() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (String) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return "QQFavoriteMigration";
        }

        @Override // mqq.app.ISecurityFileHelper
        public boolean needMigration() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            if (needMoveFile()) {
                File file = new File(AppConstants.SDCARD_IMG_FAVORITE);
                if (file.exists() && file.isDirectory()) {
                    return true;
                }
                commitMove();
                return false;
            }
            return false;
        }

        @Override // mqq.app.ISecurityFileHelper
        public File oldBusinessDir(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (File) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            }
            return null;
        }

        @Override // mqq.app.ISecurityFileHelper
        public boolean oldBusinessDirExist(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str)).booleanValue();
            }
            return false;
        }

        @Override // mqq.app.ISecurityFileHelper
        public String[] reportHistoryFileInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String[]) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return new String[]{"0", "0"};
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42229);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            S_VERSION_MAP = new HashMap();
        }
    }

    public DiySecureFileHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void commitVersion(String str, String str2, int i3) {
        int i16;
        String str3 = str + "_" + str2;
        Map<String, Integer> map = S_VERSION_MAP;
        synchronized (map) {
            if (map.containsKey(str3)) {
                i16 = map.get(str3).intValue();
            } else {
                i16 = -1;
            }
            if (i16 != i3) {
                BaseApplication.getContext().getSharedPreferences("StepUpdate", 4).edit().putInt(str3, i3).commit();
                map.put(str3, Integer.valueOf(i3));
            }
        }
    }

    public static String getSdcardDIYDir() {
        return VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "custom_background/");
    }

    public static int getVersion(String str, String str2) {
        int i3;
        String str3 = str + "_" + str2;
        Map<String, Integer> map = S_VERSION_MAP;
        synchronized (map) {
            if (map.containsKey(str3)) {
                i3 = map.get(str3).intValue();
            } else {
                int i16 = BaseApplication.getContext().getSharedPreferences("StepUpdate", 4).getInt(str3, 0);
                map.put(str3, Integer.valueOf(i16));
                i3 = i16;
            }
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void rfQuickMove(String str, String str2) {
        File file = new File(str);
        if (file.exists()) {
            if (file.isFile()) {
                int quickMove = FileUtils.quickMove(str, str2);
                if (quickMove != 0) {
                    QLog.d(TAG, 1, "Move [" + str + "] errorcode = " + quickMove);
                }
            } else if (file.isDirectory()) {
                for (File file2 : safeListFiles(file)) {
                    rfQuickMove(file2.getAbsolutePath(), new File(str2, file2.getName()).getAbsolutePath());
                }
            }
            FileUtils.deleteDirectory(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static File[] safeListFiles(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            QLog.e(TAG, 1, new Throwable(), new Object[0]);
            return new File[0];
        }
        return listFiles;
    }

    public static String secureUin(String str) {
        if (str.length() > 4) {
            String substring = str.substring(4);
            if (QLog.isDevelopLevel()) {
                QLog.d(TAG, 4, str + " -> " + substring);
            }
            return substring;
        }
        return str;
    }
}
