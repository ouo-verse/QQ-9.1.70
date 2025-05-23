package com.tencent.mobileqq.activity.aio.tim;

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
    public static String f180005m = "tim_need_show_text_bubble";

    /* renamed from: n, reason: collision with root package name */
    private static final String f180006n;

    /* renamed from: o, reason: collision with root package name */
    private static final String f180007o;

    /* renamed from: p, reason: collision with root package name */
    private static a f180008p;

    /* renamed from: q, reason: collision with root package name */
    private static final String f180009q;

    /* renamed from: a, reason: collision with root package name */
    private volatile int f180010a = 0;

    /* renamed from: c, reason: collision with root package name */
    private boolean f180012c = false;

    /* renamed from: d, reason: collision with root package name */
    private int f180013d = 0;

    /* renamed from: e, reason: collision with root package name */
    private int f180014e = 0;

    /* renamed from: f, reason: collision with root package name */
    private int f180015f = 0;

    /* renamed from: g, reason: collision with root package name */
    private String f180016g = "";

    /* renamed from: h, reason: collision with root package name */
    private String f180017h = "";

    /* renamed from: i, reason: collision with root package name */
    private String f180018i = "";

    /* renamed from: j, reason: collision with root package name */
    private String f180019j = f180009q;

    /* renamed from: k, reason: collision with root package name */
    private boolean f180020k = false;

    /* renamed from: l, reason: collision with root package name */
    private String f180021l = "";

    /* renamed from: b, reason: collision with root package name */
    private boolean f180011b = false;

    static {
        StringBuilder sb5 = new StringBuilder();
        String str = AppConstants.SDCARD_AIO_TIM_THEME_DIR;
        sb5.append(str);
        sb5.append("icons/");
        f180006n = sb5.toString();
        f180007o = str + "zip/";
        f180009q = HardCodeUtil.qqStr(R.string.u6i);
    }

    a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int h(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.i("TIMUserManager", 2, " doDowndLoadTimThemeZip zipUrl " + str);
        }
        String str3 = f180006n;
        File file = new File(str3);
        File file2 = new File(f180007o);
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
            FileUtils.deleteFilesInDirectory(f180007o);
        }
        g gVar = new g(str, new File(f180007o + "android_tim_theme_icons.zip"));
        gVar.S = "profileCardDownload";
        gVar.R = "VIP_profilecard";
        return DownloaderFactory.o(gVar, null);
    }

    public static a i() {
        if (f180008p == null) {
            f180008p = new a();
        }
        return f180008p;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l(String str) {
        File file = new File(f180007o + "android_tim_theme_icons.zip");
        if (!file.exists()) {
            return false;
        }
        try {
            String calcMd5 = FileUtils.calcMd5(file.getPath());
            if (!TextUtils.isEmpty(calcMd5) && calcMd5.equalsIgnoreCase(str)) {
                try {
                    String str2 = f180006n;
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
            if (!this.f180012c || !this.f180021l.equals(account)) {
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(qQAppInterface.getApp());
                if (defaultSharedPreferences.contains(account + "_" + AppConstants.Preferences.TIM_USER_SPECIAL_CONFIG_VERSION)) {
                    this.f180013d = defaultSharedPreferences.getInt(account + "_" + AppConstants.Preferences.TIM_USER_SPECIAL_AVATAR_SWITCH, 0);
                    this.f180014e = defaultSharedPreferences.getInt(account + "_" + AppConstants.Preferences.TIM_USER_SPECIAL_TITLE_BG_SWITCH, 0);
                    this.f180015f = defaultSharedPreferences.getInt(account + "_" + AppConstants.Preferences.TIM_USER_SPECIAL_BUBBLE_SWITCH, 0);
                    this.f180016g = defaultSharedPreferences.getString(account + "_" + AppConstants.Preferences.TIM_USER_SPECIAL_RESOURCE_URL, "");
                    this.f180018i = defaultSharedPreferences.getString(account + "_" + AppConstants.Preferences.TIM_USER_SPECIAL_RESOURCE_MD5, "");
                    this.f180017h = defaultSharedPreferences.getString(account + "_" + AppConstants.Preferences.TIM_USER_SPECIAL_TIM_WEBSITE, "");
                    this.f180019j = defaultSharedPreferences.getString(account + "_" + AppConstants.Preferences.TIM_USER_SPECIAL_ONLINE_WORDING, f180009q);
                    this.f180020k = defaultSharedPreferences.getBoolean(AppConstants.Preferences.TIM_USER_SPECIAL_FORCE_DOWDLORD, false);
                }
                this.f180021l = account;
                this.f180012c = true;
                if (QLog.isColorLevel()) {
                    QLog.d("TIMUserManager", 2, String.format("readAllConfigFromSp, first init,avatarSwitch %d, titleBarSwitch : %d, bubbleSwitch: %d, resourceUrl:%s ,md5:%s , onlineWording:%s, needForceDownload:%b, mTimWebsite:%s", Integer.valueOf(this.f180013d), Integer.valueOf(this.f180014e), Integer.valueOf(this.f180014e), this.f180016g, this.f180018i, this.f180019j, Boolean.valueOf(this.f180020k), this.f180017h));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        File file = new File(f180006n);
        if (file.exists() && file.isDirectory()) {
            SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSharedPreferences("tim_theme_icon_names_sp", 0).edit();
            String[] list = file.list();
            StringBuilder sb5 = new StringBuilder();
            for (String str : list) {
                sb5.append(str.substring(str.lastIndexOf("/") + 1) + "|");
            }
            edit.putString("android_tim_theme_icon_names", sb5.toString());
            edit.apply();
        }
    }

    public String j(QQAppInterface qQAppInterface) {
        m(qQAppInterface);
        return this.f180018i;
    }

    public String k(QQAppInterface qQAppInterface) {
        m(qQAppInterface);
        return this.f180016g;
    }

    public void o(int i3, int i16, String str, String str2, String str3, String str4, boolean z16, int i17) {
        this.f180012c = true;
        this.f180013d = i3;
        this.f180014e = i16;
        this.f180016g = str;
        this.f180017h = str2;
        this.f180018i = str3;
        this.f180019j = str4;
        this.f180020k = z16;
        this.f180015f = i17;
        if (QLog.isColorLevel()) {
            QLog.d("TIMUserManager", 2, String.format("setTimUserSpecial, first init,avatarSwitch %d, titleBarSwitch : %d, bubbleSwitch: %d, resourceUrl:%s ,md5:%s , onlineWording:%s, needForceDownload:%b, timWebsite:%s", Integer.valueOf(this.f180013d), Integer.valueOf(this.f180014e), Integer.valueOf(this.f180014e), this.f180016g, this.f180018i, this.f180019j, Boolean.valueOf(this.f180020k), str2));
        }
    }
}
