package com.tencent.mobileqq.filemanager.data;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.filemanager.util.am;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import javax.xml.parsers.SAXParserFactory;

/* compiled from: P */
/* loaded from: classes12.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f207740a = false;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f207741b = false;

    public static int A() {
        int i3;
        try {
            i3 = Integer.parseInt(f(BaseApplication.getContext(), "TimAioCount"));
        } catch (Exception unused) {
            i3 = 0;
        }
        if (i3 != 0 && TextUtils.isEmpty(B())) {
            return 0;
        }
        return i3;
    }

    public static String B() {
        String str;
        try {
            str = f(BaseApplication.getContext(), "TimGuideUrl");
        } catch (Exception unused) {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            return "https://mma.qq.com/tim/timoffice/office.html";
        }
        return str;
    }

    public static void C(BaseQQAppInterface baseQQAppInterface, String str, long j3) {
        File file = new File(baseQQAppInterface.getApplicationContext().getFilesDir(), "FileOnlinePreviewConfigV2");
        try {
            if (HttpDownloadUtil.download(baseQQAppInterface, str, file)) {
                try {
                    SAXParserFactory.newInstance().newSAXParser().parse(file, new QQFileManagerUtilImpl.i());
                } catch (Throwable th5) {
                    if (QLog.isColorLevel()) {
                        QLog.d("FMConfig<FileAssistant>", 2, "updateGuide with: " + QLog.getStackTraceString(th5));
                    }
                }
            } else if (QLog.isColorLevel()) {
                QLog.d("FMConfig<FileAssistant>", 2, "updateGuide download xml failed: " + str);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public static String a(Context context, String str) {
        String string = context.getSharedPreferences("OfflineFileConfigV2", 0).getString(str.toLowerCase(), null);
        if (string != null && string.length() > 0) {
            return string;
        }
        return QQFileManagerUtilImpl.Y0(str);
    }

    public static String b(Context context, String str, String str2, String str3) {
        return a(context, str + str2 + str3);
    }

    public static long c() {
        long parseLong = Long.parseLong(ah.t0("OfflineConfigFlowSize"));
        try {
            parseLong = Long.parseLong(f(BaseApplication.getContext(), "FlowSize"));
        } catch (Exception unused) {
        }
        return (parseLong * 1024) + 1;
    }

    public static long d() {
        long parseLong = Long.parseLong(ah.t0("OfflineConfigFlowTime"));
        try {
            parseLong = Long.parseLong(f(BaseApplication.getContext(), "FlowTime"));
        } catch (Exception unused) {
        }
        return parseLong * 60;
    }

    public static long e() {
        long parseLong = Long.parseLong(ah.t0("OfflineConfigFtnThumbMaxSize"));
        try {
            parseLong = Long.parseLong(f(BaseApplication.getContext(), "FtnThumbMaxSize"));
        } catch (Exception unused) {
        }
        return parseLong * 1024;
    }

    public static String f(Context context, String str) {
        return b(context, "OfflineConfig", str, "");
    }

    public static String g(Context context, String str, String str2) {
        String j3 = am.j(str);
        String replace = j3.replace(".", "");
        String b16 = b(context, "OnlinePreView", replace, str2);
        if (QLog.isColorLevel()) {
            QLog.d("FMConfig<FileAssistant>", 2, "getPreviewConfig fileExt: " + j3 + ", configKey: " + replace + ", config: " + b16);
        }
        return b16;
    }

    public static boolean h() {
        return f207741b;
    }

    public static boolean i() {
        return f207740a;
    }

    public static boolean j(BaseQQAppInterface baseQQAppInterface) {
        return com.tencent.mobileqq.filemanager.util.h.a(baseQQAppInterface, "https_c2c_down", false);
    }

    public static boolean k(BaseQQAppInterface baseQQAppInterface) {
        return com.tencent.mobileqq.filemanager.util.h.a(baseQQAppInterface, "https_c2czip_down", false);
    }

    public static boolean l(BaseQQAppInterface baseQQAppInterface) {
        return com.tencent.mobileqq.filemanager.util.h.a(baseQQAppInterface, "https_disc_down", false);
    }

    public static boolean m(BaseQQAppInterface baseQQAppInterface) {
        return com.tencent.mobileqq.filemanager.util.h.a(baseQQAppInterface, "https_disczip_down", false);
    }

    public static boolean n(BaseQQAppInterface baseQQAppInterface) {
        return com.tencent.mobileqq.filemanager.util.h.a(baseQQAppInterface, "https_c2c_thumb", false);
    }

    public static boolean o(BaseQQAppInterface baseQQAppInterface) {
        return com.tencent.mobileqq.filemanager.util.h.a(baseQQAppInterface, "https_disc_thumb", false);
    }

    public static boolean p(BaseQQAppInterface baseQQAppInterface) {
        return com.tencent.mobileqq.filemanager.util.h.a(baseQQAppInterface, "https_c2c_up", false);
    }

    public static boolean q(BaseQQAppInterface baseQQAppInterface) {
        return com.tencent.mobileqq.filemanager.util.h.a(baseQQAppInterface, "https_disc_up", false);
    }

    public static boolean r() {
        boolean readValue = SettingCloneUtil.readValue((Context) BaseApplication.getContext(), (String) null, BaseApplication.getContext().getString(R.string.f213875rd), AppConstants.QQSETTING_AUTO_RECEIVE_PIC_KEY, true);
        QLog.i("FMConfig<FileAssistant>", 1, "PreloadThumb switch is[" + readValue + "]");
        return readValue;
    }

    public static void s(BaseQQAppInterface baseQQAppInterface, boolean z16) {
        com.tencent.mobileqq.filemanager.util.h.f(baseQQAppInterface, "https_c2c_down", z16);
    }

    public static void t(BaseQQAppInterface baseQQAppInterface, boolean z16) {
        com.tencent.mobileqq.filemanager.util.h.f(baseQQAppInterface, "https_c2czip_down", z16);
    }

    public static void u(BaseQQAppInterface baseQQAppInterface, boolean z16) {
        com.tencent.mobileqq.filemanager.util.h.f(baseQQAppInterface, "https_disc_down", z16);
    }

    public static void v(BaseQQAppInterface baseQQAppInterface, boolean z16) {
        com.tencent.mobileqq.filemanager.util.h.f(baseQQAppInterface, "https_disczip_down", z16);
    }

    public static void w(BaseQQAppInterface baseQQAppInterface, boolean z16) {
        com.tencent.mobileqq.filemanager.util.h.f(baseQQAppInterface, "https_c2c_thumb", z16);
    }

    public static void x(BaseQQAppInterface baseQQAppInterface, boolean z16) {
        com.tencent.mobileqq.filemanager.util.h.f(baseQQAppInterface, "https_disc_thumb", z16);
    }

    public static void y(BaseQQAppInterface baseQQAppInterface, boolean z16) {
        com.tencent.mobileqq.filemanager.util.h.f(baseQQAppInterface, "https_c2c_up", z16);
    }

    public static void z(BaseQQAppInterface baseQQAppInterface, boolean z16) {
        com.tencent.mobileqq.filemanager.util.h.f(baseQQAppInterface, "https_disc_up", z16);
    }
}
