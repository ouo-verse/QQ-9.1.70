package com.tencent.util;

import android.app.Activity;
import android.content.SharedPreferences;
import com.tencent.aelight.camera.api.ICameraSaveApi;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.eb;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AutoSaveUtils;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mqq.app.Foreground;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AutoSaveUtils {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.util.AutoSaveUtils$1, reason: invalid class name */
    /* loaded from: classes27.dex */
    public class AnonymousClass1 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f383925d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f383926e;

        AnonymousClass1(String str, boolean z16) {
            this.f383925d = str;
            this.f383926e = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Boolean.valueOf(z16));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(File file, boolean z16, String str) {
            QLog.d("AutoSaveUtils", 1, "autoSavePic success:" + z16 + " savePath:" + str);
            FileUtils.deleteFile(file);
        }

        @Override // java.lang.Runnable
        public void run() {
            String estimateVideoType;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            Activity topActivity = Foreground.getTopActivity();
            if (topActivity == null) {
                QLog.e("AutoSaveUtils", 1, "autoSavePic error: currrent activity is null");
                return;
            }
            File file = new File(this.f383925d);
            if (!file.exists()) {
                QLog.e("AutoSaveUtils", 1, "autoSavePic error:" + file.getAbsolutePath() + " is not exist");
                return;
            }
            final File file2 = new File(BaseApplicationImpl.getApplication().getExternalFilesDir(null), file.getName());
            if (file2.exists()) {
                QLog.e("AutoSaveUtils", 1, "autoSavePic error:" + file2.getAbsolutePath() + " is exist, copy failed");
                return;
            }
            if (!FileUtils.copyFile(file, file2)) {
                QLog.e("AutoSaveUtils", 1, "autoSavePic failed: copy failed");
                return;
            }
            QLog.d("AutoSaveUtils", 1, "autoSavePic copy succes: copy to " + file2.getAbsolutePath());
            String absolutePath = file.getAbsolutePath();
            String str = AppConstants.SDCARD_IMG_CAMERA;
            new File(str).mkdirs();
            String Crc64String = Utils.Crc64String(absolutePath);
            if (!Crc64String.contains(".")) {
                if (this.f383926e) {
                    estimateVideoType = FileUtils.estimateFileType(absolutePath);
                } else {
                    estimateVideoType = FileUtils.estimateVideoType(absolutePath);
                }
                Crc64String = Crc64String + "." + estimateVideoType;
            }
            File file3 = new File(str, Crc64String);
            if (!file3.exists()) {
                ((ICameraSaveApi) QRoute.api(ICameraSaveApi.class)).saveMediaToAlbum(topActivity, file2, file3.getAbsolutePath(), new ss.e() { // from class: com.tencent.util.a
                    @Override // ss.e
                    public final void onResult(boolean z16, String str2) {
                        AutoSaveUtils.AnonymousClass1.b(file2, z16, str2);
                    }
                });
            }
        }
    }

    public static void a(boolean z16, String str) {
        String str2;
        if (g(z16)) {
            if (QLog.isColorLevel()) {
                QLog.d("AutoSaveUtils", 2, "addAutoSavePath: isPic " + z16 + ",tempPath=" + str);
            }
            HashSet hashSet = new HashSet(h(z16));
            hashSet.add(str);
            SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSharedPreferences("setting_auto_save_sp", 4).edit();
            if (z16) {
                str2 = "qqsetting_auto_save_path_pic_key";
            } else {
                str2 = "qqsetting_auto_save_path_video_key";
            }
            eb.b(edit, str2, hashSet);
            edit.commit();
        }
    }

    public static void b(String str, boolean z16) {
        c(str, z16, false);
    }

    public static void c(String str, boolean z16, boolean z17) {
        if (g(z16)) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(str, z16);
            if (z17) {
                anonymousClass1.run();
            } else {
                ThreadManagerV2.executeOnFileThread(anonymousClass1);
            }
        }
    }

    public static void d(boolean z16, String str) {
        if (str == null) {
            return;
        }
        e(z16, Collections.singletonList(str));
    }

    public static void e(boolean z16, List<String> list) {
        if (list != null && list.size() != 0 && g(z16)) {
            Set<String> h16 = h(z16);
            for (String str : list) {
                if (QLog.isColorLevel()) {
                    QLog.d("AutoSaveUtils", 2, "autoSaveMediaInSp: isPic " + z16 + ",path=" + str);
                }
                if (h16.contains(str)) {
                    b(str, z16);
                }
            }
            f(z16);
        }
    }

    private static void f(boolean z16) {
        String str;
        SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSharedPreferences("setting_auto_save_sp", 4).edit();
        if (z16) {
            str = "qqsetting_auto_save_path_pic_key";
        } else {
            str = "qqsetting_auto_save_path_video_key";
        }
        edit.putStringSet(str, new HashSet());
        edit.commit();
    }

    public static boolean g(boolean z16) {
        String str;
        SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("setting_auto_save_sp", 4);
        StringBuilder sb5 = new StringBuilder();
        if (z16) {
            str = AppConstants.QQSETTING_AUTO_SAVE_PIC_KEY;
        } else {
            str = AppConstants.QQSETTING_AUTO_SAVE_VIDEO_KEY;
        }
        sb5.append(str);
        sb5.append(BaseApplicationImpl.getApplication().getRuntime().getAccount());
        return sharedPreferences.getBoolean(sb5.toString(), false);
    }

    private static Set<String> h(boolean z16) {
        String str;
        SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("setting_auto_save_sp", 4);
        if (z16) {
            str = "qqsetting_auto_save_path_pic_key";
        } else {
            str = "qqsetting_auto_save_path_video_key";
        }
        return eb.a(sharedPreferences, str, new HashSet());
    }

    public static void i(boolean z16, boolean z17) {
        String str;
        SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSharedPreferences("setting_auto_save_sp", 4).edit();
        StringBuilder sb5 = new StringBuilder();
        if (z16) {
            str = AppConstants.QQSETTING_AUTO_SAVE_PIC_KEY;
        } else {
            str = AppConstants.QQSETTING_AUTO_SAVE_VIDEO_KEY;
        }
        sb5.append(str);
        sb5.append(BaseApplicationImpl.getApplication().getRuntime().getAccount());
        edit.putBoolean(sb5.toString(), z17);
        edit.commit();
    }
}
