package com.tencent.mobileqq.activity.aio.qim;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.g;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {

    /* renamed from: m, reason: collision with root package name */
    public static String f179779m = "qim_need_show_text_bubble";

    /* renamed from: n, reason: collision with root package name */
    private static final String f179780n;

    /* renamed from: o, reason: collision with root package name */
    private static final String f179781o;

    /* renamed from: p, reason: collision with root package name */
    private static a f179782p;

    /* renamed from: q, reason: collision with root package name */
    private static final String f179783q;

    /* renamed from: a, reason: collision with root package name */
    private volatile int f179784a = 0;

    /* renamed from: c, reason: collision with root package name */
    private boolean f179786c = false;

    /* renamed from: d, reason: collision with root package name */
    private int f179787d = 0;

    /* renamed from: e, reason: collision with root package name */
    private int f179788e = 0;

    /* renamed from: f, reason: collision with root package name */
    private int f179789f = 0;

    /* renamed from: g, reason: collision with root package name */
    private String f179790g = "";

    /* renamed from: h, reason: collision with root package name */
    private String f179791h = "";

    /* renamed from: i, reason: collision with root package name */
    private String f179792i = "";

    /* renamed from: j, reason: collision with root package name */
    private String f179793j = f179783q;

    /* renamed from: k, reason: collision with root package name */
    private boolean f179794k = false;

    /* renamed from: l, reason: collision with root package name */
    private String f179795l = "";

    /* renamed from: b, reason: collision with root package name */
    private boolean f179785b = false;

    static {
        StringBuilder sb5 = new StringBuilder();
        String str = AppConstants.SDCARD_AIO_QIM_THEME_DIR;
        sb5.append(str);
        sb5.append("icons/");
        f179780n = sb5.toString();
        f179781o = str + "zip/";
        f179783q = HardCodeUtil.qqStr(R.string.qeq);
    }

    a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int h(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.i("QIMUserManager", 2, " doDowndLoadQimThemeZip zipUrl " + str);
        }
        String str3 = f179780n;
        File file = new File(str3);
        File file2 = new File(f179781o);
        if (!file.exists()) {
            file.mkdirs();
            try {
                new File(str3 + ".nomedia").createNewFile();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        } else {
            FileUtils.deleteFilesInDirectory(str3);
        }
        if (!file2.exists()) {
            file2.mkdirs();
        } else {
            FileUtils.deleteFilesInDirectory(f179781o);
        }
        g gVar = new g(str, new File(f179781o + "android_qim_theme_icons.zip"));
        gVar.S = "profileCardDownload";
        gVar.R = "VIP_profilecard";
        return DownloaderFactory.o(gVar, null);
    }

    public static a i() {
        if (f179782p == null) {
            f179782p = new a();
        }
        return f179782p;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l(String str) {
        File file = new File(f179781o + "android_qim_theme_icons.zip");
        if (!file.exists()) {
            return false;
        }
        try {
            String calcMd5 = FileUtils.calcMd5(file.getPath());
            if (!TextUtils.isEmpty(calcMd5) && calcMd5.equalsIgnoreCase(str)) {
                try {
                    String str2 = f179780n;
                    FileUtils.deleteFilesInDirectory(str2);
                    ZipUtils.unZipFile(file, str2);
                    return true;
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        e16.printStackTrace();
                    }
                }
            }
            return false;
        } catch (UnsatisfiedLinkError e17) {
            if (QLog.isColorLevel()) {
                e17.printStackTrace();
            }
            return false;
        }
    }

    private void m(QQAppInterface qQAppInterface) {
        if (qQAppInterface != null) {
            String account = qQAppInterface.getAccount();
            if (!this.f179786c || !this.f179795l.equals(account)) {
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(qQAppInterface.getApp());
                if (defaultSharedPreferences.contains(account + "_" + AppConstants.Preferences.QIM_USER_SPECIAL_CONFIG_VERSION)) {
                    this.f179787d = defaultSharedPreferences.getInt(account + "_" + AppConstants.Preferences.QIM_USER_SPECIAL_AVATAR_SWITCH, 0);
                    this.f179788e = defaultSharedPreferences.getInt(account + "_" + AppConstants.Preferences.QIM_USER_SPECIAL_TITLE_BG_SWITCH, 0);
                    this.f179789f = defaultSharedPreferences.getInt(account + "_" + AppConstants.Preferences.QIM_USER_SPECIAL_BUBBLE_SWITCH, 0);
                    this.f179790g = defaultSharedPreferences.getString(account + "_" + AppConstants.Preferences.QIM_USER_SPECIAL_RESOURCE_URL, "");
                    this.f179792i = defaultSharedPreferences.getString(account + "_" + AppConstants.Preferences.QIM_USER_SPECIAL_RESOURCE_MD5, "");
                    this.f179791h = defaultSharedPreferences.getString(account + "_" + AppConstants.Preferences.QIM_USER_SPECIAL_QIM_WEBSITE, "");
                    this.f179793j = defaultSharedPreferences.getString(account + "_" + AppConstants.Preferences.QIM_USER_SPECIAL_ONLINE_WORDING, f179783q);
                    this.f179794k = defaultSharedPreferences.getBoolean(AppConstants.Preferences.QIM_USER_SPECIAL_FORCE_DOWDLORD, false);
                }
                this.f179795l = account;
                this.f179786c = true;
                if (QLog.isColorLevel()) {
                    QLog.d("QIMUserManager", 2, String.format("readAllConfigFromSp, first init,avatarSwitch %d, titleBarSwitch : %d, bubbleSwitch: %d, resourceUrl:%s ,md5:%s , onlineWording:%s, needForceDownload:%b, mQimWebsite:%s", Integer.valueOf(this.f179787d), Integer.valueOf(this.f179788e), Integer.valueOf(this.f179788e), this.f179790g, this.f179792i, this.f179793j, Boolean.valueOf(this.f179794k), this.f179791h));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        File file = new File(f179780n);
        if (file.exists() && file.isDirectory()) {
            SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSharedPreferences("qim_theme_icon_names_sp", 0).edit();
            String[] list = file.list();
            StringBuilder sb5 = new StringBuilder();
            for (String str : list) {
                sb5.append(str.substring(str.lastIndexOf("/") + 1) + "|");
            }
            edit.putString("android_qim_theme_icon_names", sb5.toString());
            edit.apply();
        }
    }

    public String j(QQAppInterface qQAppInterface) {
        m(qQAppInterface);
        return this.f179792i;
    }

    public String k(QQAppInterface qQAppInterface) {
        m(qQAppInterface);
        return this.f179790g;
    }

    public void o(int i3, int i16, String str, String str2, String str3, String str4, boolean z16, int i17) {
        this.f179786c = true;
        this.f179787d = i3;
        this.f179788e = i16;
        this.f179790g = str;
        this.f179791h = str2;
        this.f179792i = str3;
        this.f179793j = str4;
        this.f179794k = z16;
        this.f179789f = i17;
        if (QLog.isColorLevel()) {
            QLog.d("QIMUserManager", 2, String.format("setQimUserSpecial, first init,avatarSwitch %d, titleBarSwitch : %d, bubbleSwitch: %d, resourceUrl:%s ,md5:%s , onlineWording:%s, needForceDownload:%b, qimWebsite:%s", Integer.valueOf(this.f179787d), Integer.valueOf(this.f179788e), Integer.valueOf(this.f179788e), this.f179790g, this.f179792i, this.f179793j, Boolean.valueOf(this.f179794k), str2));
        }
    }
}
